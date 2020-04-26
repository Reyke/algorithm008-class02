# HashMap

---

## Put()方法

```Java
//put方法，会先调用一个hash()方法，得到当前key的一个hash值，
//用于确定当前key应该存放在数组的哪个下标位置
//这里的 hash方法，我们姑且先认为是key.hashCode()，其实不是的，一会儿细讲
public V put(K key, V value) {
	return putVal(hash(key), key, value, false, true);
}

//把hash值和当前的key，value传入进来
//这里onlyIfAbsent如果为true，表明不能修改已经存在的值，因此我们传入false
//evict只有在方法 afterNodeInsertion(boolean evict) { }用到，可以看到它是一个空实现，因此不用关注这个参数
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
			   boolean evict) {
	Node<K,V>[] tab; Node<K,V> p; int n, i;
	//判断table是否为空，如果空的话，会先调用resize扩容
	if ((tab = table) == null || (n = tab.length) == 0)
		n = (tab = resize()).length;
	//根据当前key的hash值找到它在数组中的下标，判断当前下标位置是否已经存在元素，
	//若没有，则把key、value包装成Node节点，直接添加到此位置。
	// i = (n - 1) & hash 是计算下标位置的，为什么这样算，后边讲
	if ((p = tab[i = (n - 1) & hash]) == null)
		tab[i] = newNode(hash, key, value, null);
	else {
		//如果当前位置已经有元素了，分为三种情况。
		Node<K,V> e; K k;
		//1.当前位置元素的hash值等于传过来的hash，并且他们的key值也相等，
		//则把p赋值给e，跳转到①处，后续需要做值的覆盖处理
		if (p.hash == hash &&
			((k = p.key) == key || (key != null && key.equals(k))))
			e = p;
		//2.如果当前是红黑树结构，则把它加入到红黑树
		else if (p instanceof TreeNode)
			e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
		else {
		//3.说明此位置已存在元素，并且是普通链表结构，则采用尾插法，把新节点加入到链表尾部
			for (int binCount = 0; ; ++binCount) {
				if ((e = p.next) == null) {
					//如果头结点的下一个节点为空，则插入新节点
					p.next = newNode(hash, key, value, null);
					//如果在插入的过程中，链表长度超过了8，则转化为红黑树
					if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
						treeifyBin(tab, hash);
					//插入成功之后，跳出循环，跳转到①处
					break;
				}
				//若在链表中找到了相同key的话，直接退出循环，跳转到①处
				if (e.hash == hash &&
					((k = e.key) == key || (key != null && key.equals(k))))
					break;
				p = e;
			}
		}
		//① 此时e有两种情况
		//1.说明发生了碰撞，e代表的是旧值，因此节点位置不变，但是需要替换为新值
		//2.说明e是插入链表或者红黑树，成功后的新节点
		if (e != null) { // existing mapping for key
			V oldValue = e.value;
			//用新值替换旧值，并返回旧值。
			//oldValue为空，说明e是新增的节点或者也有可能旧值本来就是空的，因为hashmap可存空值
			if (!onlyIfAbsent || oldValue == null)
				e.value = value;
			//看方法名字即可知，这是在node被访问之后需要做的操作。其实此处是一个空实现，
			//只有在 LinkedHashMap才会实现，用于实现根据访问先后顺序对元素进行排序，hashmap不提供排序功能
			// Callbacks to allow LinkedHashMap post-actions
			//void afterNodeAccess(Node<K,V> p) { }
			afterNodeAccess(e);
			return oldValue;
		}
	}
	//fail-fast机制
	++modCount;
	//如果当前数组中的元素个数超过阈值，则扩容
	if (++size > threshold)
		resize();
	//同样的空实现
	afterNodeInsertion(evict);
	return null;
}

```

---

## get（） 方法

```Java
public V get(Object key) {
	Node<K,V> e;
	//如果节点为空，则返回null，否则返回节点的value。这也说明，hashMap是支持value为null的。
	//因此，我们就明白了，为什么hashMap支持Key和value都为null
	return (e = getNode(hash(key), key)) == null ? null : e.value;
}

final Node<K,V> getNode(int hash, Object key) {
	Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
	//首先要确保数组不能为空，然后取到当前hash值计算出来的下标位置的第一个元素
	if ((tab = table) != null && (n = tab.length) > 0 &&
		(first = tab[(n - 1) & hash]) != null) {
		//若hash值和key都相等，则说明我们要找的就是第一个元素，直接返回
		if (first.hash == hash && // always check first node
			((k = first.key) == key || (key != null && key.equals(k))))
			return first;
		//如果不是的话，就遍历当前链表（或红黑树）
		if ((e = first.next) != null) {
			//如果是红黑树结构，则找到当前key所在的节点位置
			if (first instanceof TreeNode)
				return ((TreeNode<K,V>)first).getTreeNode(hash, key);
			//如果是普通链表，则向后遍历查找，直到找到或者遍历到链表末尾为止。
			do {
				if (e.hash == hash &&
					((k = e.key) == key || (key != null && key.equals(k))))
					return e;
			} while ((e = e.next) != null);
		}
	}
	//否则，说明没有找到，返回null
	return null;
}

```
