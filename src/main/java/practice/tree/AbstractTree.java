package practice.tree;

/**
 * 定义一个抽象的tree 方便DispalyTree这个可视化类调用
 * @author lh
 * @date 2017年10月18日
 * @version 
 * @param <T>
 */
public abstract class AbstractTree<T extends Comparable<T>> {
	
	/**
	 * 搜索元素是否存在
	 * @param t
	 * @return
	 */
	abstract boolean search(T value);
	abstract boolean insert(T value);
	abstract boolean delete(T value);
	abstract TreeNode<T> getRoot();

}
