/**
 * 
 */
package nc.itf.pu;

import java.util.HashMap;

import nc.vo.pu.cgfa.AggCgfa;
import nc.vo.pub.lang.UFDouble;

/**
 * @author wangzym
 * @version 2017年5月5日 下午3:10:48
 */
public interface IQueryForLineClose {

	/**
	 * 查询子表数据是否在下游已经生成单据
	 */
	public int[] hasForword(HashMap<Integer, String> bpks);

	public void reWritePrayBill(String[] bpks, UFDouble[] ufDoubles,
			String actionName);

	/**
	 * @param pks
	 * @param actionName
	 */
	public void updateForSelf(String[] pks, String actionName);

	/**
	 * 行关闭后找到后续相关的采购方案
	 * 
	 * @param 采购方案来源子表主键
	 *            （请购单子表主键）
	 */
	public AggCgfa[] findRelationCgfa(String[] pks);

}
