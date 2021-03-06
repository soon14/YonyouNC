package nc.vo.pu.pub.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.pub.MathTool;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @since 6.0
 * @version 2011-7-1 上午10:02:08
 * @author wuxla 这也好意思叫工具类。。。。
 */

public class VOSortUtils {
	public static class CrownoVOComparator<T extends CircularlyAccessibleValueObject>
			implements Comparator<T>, Serializable {

		private static final long serialVersionUID = -8948166332436870536L;

		private String crowno;

		public CrownoVOComparator(String crowno) {
			this.crowno = crowno;
		}

		@Override
		public int compare(T o1, T o2) {

			UFDouble crowno1 = new UFDouble(
					(String) o1.getAttributeValue(this.crowno));
			UFDouble crowno2 = new UFDouble(
					(String) o2.getAttributeValue(this.crowno));
			return MathTool.compareTo(crowno1, crowno2);
		}
	}

	public static <T extends CircularlyAccessibleValueObject> void ascSort(
			T[] vos, String field) {
		if (vos == null || StringUtils.isEmpty(field)) {
			return;
		}
		Comparator<T> c = new CrownoVOComparator<T>(field);
		Arrays.sort(vos, c);
	}

	/**
	 * 根据aggvo表头vo的指定字段升序排序
	 * 
	 * @param vos
	 * @param sortField
	 */
	public static void sortVOs(AggregatedValueObject[] vos,
			final String sortField) {
		if (ArrayUtils.isEmpty(vos)) {
			return;
		}
		Arrays.sort(vos, new Comparator<AggregatedValueObject>() {
			@Override
			public int compare(AggregatedValueObject vo1,
					AggregatedValueObject vo2) {
				String key1 = (String) vo1.getParentVO().getAttributeValue(
						sortField);
				String key2 = (String) vo2.getParentVO().getAttributeValue(
						sortField);
				if (key1 == null) {
					key1 = "";
				}
				if (key2 == null) {
					key2 = "";
				}
				return key1.compareTo(key2);
			}
		});
	}

	/**
	 * 根据CircularlyAccessibleValueObject vo指定字段升序排序
	 * 
	 * @param vos
	 * @param sortField
	 */
	public static void sortVOs(CircularlyAccessibleValueObject[] vos,
			final String sortField) {
		if (ArrayUtils.isEmpty(vos)) {
			return;
		}
		Arrays.sort(vos, new Comparator<CircularlyAccessibleValueObject>() {
			@Override
			public int compare(CircularlyAccessibleValueObject vo1,
					CircularlyAccessibleValueObject vo2) {
				String key1 = (String) vo1.getAttributeValue(sortField);
				String key2 = (String) vo2.getAttributeValue(sortField);
				if (key1 == null) {
					key1 = "";
				}
				if (key2 == null) {
					key2 = "";
				}
				return key1.compareTo(key2);
			}
		});
	}

}
