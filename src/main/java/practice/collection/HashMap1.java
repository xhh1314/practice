package practice.collection;

/**
 * 自定义简易版HashMap数据结构,hash表和链表组成
 * 
 * @author lh
 * @date 2017年10月17日
 * @version
 * @param <K>
 * @param <V>
 */
public class HashMap1<K, V> {

	private int count;
	private Node<K, V>[] table;
	private int capacity;
	private static final int DEFAULTCAPACITY = 16;
	public V put(K k, V v) {
		int hash = hashcode(k);
		return putVal(hash, k, v);
	}

	public HashMap1(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("初始化大小错误，应大于0");
		}
		if (cap < DEFAULTCAPACITY) {
			this.capacity = DEFAULTCAPACITY;
		}
		this.capacity = cap;
	}

	public HashMap1() {
		this(DEFAULTCAPACITY);
	}

	/**
	 * @param hash
	 * @param k
	 * @param v
	 * @return 返回key 的原值
	 */
	private V putVal(int hash, K k, V v) {
		// TODO Auto-generated method stub
		if (k == null || v == null) {
			throw new IllegalArgumentException("key and  val can't be null");
		}
		int i;
		Node<K, V>[] tab;
		// table为空的时候，初始化table，同时把值插入，直接返回
		if (table == null || table.length == 0) {
			resize();
			tab=table;
			i = hash & (capacity - 1);
			tab[i] = new Node<K, V>(hash, k, v);
			count++;
			return tab[i].getValue();
		}
		tab=table;
		// 执行到这里，table不为空
		Node<K, V> old = tab[i = hash & (capacity - 1)];
		Node<K, V> val = old;
		if (val == null) {
			val = new Node<K, V>(hash, k, v);
			tab[i] = val;
		} else {
			Node<K, V> next;
			// 遍历链表
			while (true) {
				if (val.hash == hash && (val.k == k || val.k.equals(k))) {
					old.v = v;
					break;
				}
				if ((next = val.next) != null) {
					val = next;
				} else {
					break;
				}
			}
			val.next = new Node<K, V>(hash, k, v);
			val = val.next;
		}
		if (val != null) {
			this.count++;
			// 如果插入元素个数达到容量了，则重置table长度
			if (count - 1 >= this.capacity) {
				resize();
			}
		}
		return old!=null?old.v:null;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		// TODO Auto-generated method stub
		if (table == null || table.length == 0) {
			this.table = new Node[capacity];
			return;
		}
		if (this.count - 1 >= capacity) {
			capacity <<= 1;
			Node<K, V>[] newtab = new Node[capacity];
			for (int i = 0; i < table.length; i++) {
				newtab[i] = table[i];
				table[i] = null;
			}
			table = newtab;
		}

	}

	/**
	 * 求得key 的hash值
	 * 
	 * @param key
	 * @return hashcode
	 */
	private int hashcode(K key) {
		// TODO Auto-generated method stub
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	public V getValue(K k) {
		if (table == null || table.length == 0)
			return null;
		int hash = hashcode(k);
		Node<K, V> node = table[hash & (capacity - 1)];
		if (node == null) {
			return null;
		}
		// 遍历链表
		do {
			if (node.hash == hash && (node.k == k || node.k.equals(k))) {
				return node.v;
			} else {
				node = node.next;
			}
		} while (node != null);
		// 没有找到值，直接返回
		return null;
	}

	static class Node<K, V> {
		private final int hash;
		private final K k;
		private V v;
		private Node<K, V> next;

		Node(int hash, K k, V v) {
			this.hash = hash;
			this.k = k;
			this.v = v;
		}

		public V getValue() {
			// TODO Auto-generated method stub
			return this.v;
		}

		public K getKey() {
			return this.k;
		}

	}

}
