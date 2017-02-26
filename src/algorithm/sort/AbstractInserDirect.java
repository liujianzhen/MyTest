package algorithm.sort;

public abstract class AbstractInserDirect implements Sort
{

	/**
	 * ���ҵ�ǰ��Ӧ�ò����������е�λ��
	 * @param num
	 * @param initPos
	 * @return
	 */
	protected abstract int findInsertPos(int initPos);
	
	/**
	 * ����ǰ�����뵽������������Ӧ�ò��뵽��λ��
	 * @param i
	 * @param pos
	 */
	protected abstract void moveAndInsert(int initPos, int pos);
}
