package algorithm.sort;

public abstract class AbstractInserDirect implements Sort
{

	/**
	 * 查找当前数应该插入有序组中的位置
	 * @param num
	 * @param initPos
	 * @return
	 */
	protected abstract int findInsertPos(int initPos);
	
	/**
	 * 将当前数插入到其在有序组中应该插入到的位置
	 * @param i
	 * @param pos
	 */
	protected abstract void moveAndInsert(int initPos, int pos);
}
