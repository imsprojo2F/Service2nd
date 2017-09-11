/**   
* @Title: FileOperateAssistUtil.java 
* @Package com.zooori.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2017年2月6日 下午1:42:54 
* @version V1.0   
*/
package com.server.util;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: FileOperateAssistUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2017年2月6日 下午1:42:54
 * 
 */
public class FileOperateAssistUtil {

	// 日志记录
	private static Logger logger = LoggerFactory.getLogger(FileOperateAssistUtil.class);

	/**
	 * 
	 * <b>方法说明：</b> 创建文件目录，若路径存在，就不生成
	 * 
	 * <p>
	 * <b>详细描述：</b>
	 * 
	 * @param
	 * @return
	 * @author *****
	 * @since *****
	 */
	public static void createDocDir(String dirName) {
		File file = new File(dirName);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * 
	 * <b>方法说明：</b> 创建文件目录
	 * 
	 * <p>
	 * <b>详细描述：</b>
	 * 
	 * @param
	 * @return
	 * @author *****
	 * @since *****
	 */
	public static void isExistsMkDir(String dirName) {
		File file = new File(dirName);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * <b>方法说明：</b> 本地，在指定路径生成文件。若文件存在，则删除后重建。
	 * 
	 * @param dirName
	 *            本地路径名，
	 * @param file
	 *            文件，
	 * @return List<Object>
	 * @throws ServiceException
	 * @author *****
	 * @since *****
	 */
	public static void creatFileByName(File file) {
		try {
			if (file.exists()) {
				file.delete();
				logger.info("发现同名文件：{}，先执行删除，再新建。", file.getAbsolutePath());
			}
			file.createNewFile();
			logger.info("创建文件为：{}", file.getAbsolutePath());
		} catch (IOException e) {
			logger.error("创建{}文件失败", file.getAbsolutePath(), e);

		}
	}

	/**
	 * 
	 * <b>说明：</b> <b>详细描述：创建新文件，若文件存在则删除再创建，若不存在则直接创建</b>
	 * 
	 * @param
	 * @returnType File
	 * @since *****
	 * @author *****
	 */
	public static File newFile(String fileName) {
		File file = new File(fileName);
		creatFileByName(file);
		return file;
	}

	/**
	 * 
	 * <b>说明：</b> <b>详细描述：关闭写入流</b>
	 * 
	 * @param
	 * @returnType void
	 * @since *****
	 * @author *****
	 */
	public static void closeWriter(Writer writer) {
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				// throw new
				// ServiceException(BatchErrorCode.FILE_CLOSE_EXCEPTION, e);
				logger.error("Close Writer cause Exception:", e);
			}
		}
	}

	/**
	 * 
	 * <b>说明：</b> <b>详细描述：关闭写入流</b>
	 * 
	 * @param
	 * @returnType void
	 * @since *****
	 * @author *****
	 */
	public static void closeReader(Reader reader) {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				logger.error("Close reader cause Exception:", e);
			}
		}
	}

	public static String getFileBatchNo(String date) {
		if (StringUtils.isBlank(date)) {
			return CtsDateUtil.getCurPcDate();
		}
		return date;
	}

	/**
	 * <b>方法说明：</b> 将字符串拆解按特定标记解析，封装为String[]
	 * 
	 * @param String
	 *            tempString 需要拆分的字符串
	 * @param String
	 *            tempString 拆分符号
	 * @param String
	 *            tempString 拆分符号出现次数
	 * @return List<Object>
	 * @throws ServiceException
	 * @author *****
	 * @since *****
	 */
	public static String[] parseStringToStringArray(String tempString, String sign, int num) {
		List<Object> strlist = new ArrayList<Object>();
		String[] strList = new String[num + 1];
		try {
			int i;
			for (i = 0; i < num; i++) {
				String s1 = tempString.substring(0, tempString.indexOf(sign)).trim();
				tempString = tempString.substring(tempString.indexOf(sign) + 1).trim();
				strlist.add(s1);
				strList[i] = s1;
				if (i == num - 1) {
					strlist.add(tempString);
					strList[i + 1] = tempString;
					break;
				}
			}
		} catch (Exception e) {
			logger.error("解析还款清算文件失败", e);
		}
		return strList;
	}

	/***
	 * 按照指定格式分隔字符串
	 * 
	 * @param tempString
	 * @param splitChar
	 * @return
	 * @return String[]
	 */
	public static String[] splitString(String tempString, String splitChar) {
		String[] splits = (tempString.replace("||", "| | ") + (" ")).split(splitChar);
		for (int i = 0; i < splits.length; i++) {
			if (null == splits[i]) {
				splits[i] = "";
			}
		}
		return splits;
	}

	public static String packProperty(String value) {
		if (value == null) {
			return "";
		}
		return value.trim();
	}

	public static String packProperty(Integer value) {
		if (value == null) {
			return "";
		}
		return value.toString();
	}

	public static String packProperty(BigDecimal value) {
		if (value == null) {
			return "";
		}
		return value.toString();
	}

	public static String getBatchNoByFile(File file) {
		String fileName = file.getName();
		String str = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf("."));
		return str.length() <= 3 ? str : "001";
	}

}
