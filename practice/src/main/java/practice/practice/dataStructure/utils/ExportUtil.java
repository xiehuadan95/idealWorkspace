package practice.practice.dataStructure.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author xiehu
 * @Date 2022/6/27 14:57
 * @Version 1.0
 * @Description 根据一系列数据和模板 生成csv文件到某个路径下面，可供下载
 */
public class ExportUtil {
    private static final Logger logger = LoggerFactory.getLogger(ExportUtil.class);
    //CSV 文件列分隔符 , 流信息写入的时候，以逗号为标识进行区分  是否该写下一列
    private static final String CSV_COLUMN_SEPARATOR = ",";
    //CSV 文件行分隔符 ， 流信息写入的时候，进行换行，从下一行进行写数据
    private static final String CSV_RN = "\r\n";

    /**
     * 导出
     *
     * @param file     文件
     * @param dataList 数据
     * @param colNums  表头字段信息
     * @param mapKey   需要写入数据的key，通过key来获取数据信息
     * @return
     */
    public static boolean exportCsv(File file, List<Map<String, Object>> dataList, String colNums, String mapKey) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            return doExport(dataList, colNums, mapKey, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 具体生成文件的 数据处理 流输出写入文件
     * @param dataList 写入文件的数据信息Map<k,v>
     * @param colNums  输出的文件 表格 字段列信息
     * @param mapKey   通过key查找对应的数据
     * @param os       输出流信息
     * @return
     */
    public static boolean doExport(List<Map<String, Object>> dataList, String colNums, String mapKey, OutputStream os) {

        try {
            //数据处理，按照模板格式进行流写入 先新建StringBuffer 将数据加入到buf中
            StringBuffer buf = new StringBuffer();
            //头部数据列字段信息数组
            String[] colNamesArr = colNums.split(",");
            //需要获取信息的key数组
            String[] mapKeyArr = mapKey.split(",");
            //完成数据输出，写入csv文件
            //如果只是简单的表格信息
            //先将列名输出
            for (int i = 0; i < colNamesArr.length; i++) {
                buf.append(colNamesArr[i]).append(CSV_COLUMN_SEPARATOR);
            }
            //换行进行写入 具体data
            buf.append(CSV_RN);
            //输出数据
            if (null != dataList) {
                //具体有多少条数据
                for (int i = 0; i < dataList.size(); i++) {
                    //每条数据都要根据key去获取，然后填写到对应的列名下面
                    for (int j = 0; j < mapKeyArr.length; j++) {
                        //如果某个字段获取到的数据没有，则此字段数据写入文件为null 也可根据具体字段信息进行具体数据格式处理
                        if (null == dataList.get(i).get(mapKeyArr[j]) || "".equals(dataList.get(i).get(mapKeyArr[j]))) {
                            buf.append("null").append(CSV_COLUMN_SEPARATOR);
                        } else {
                            //如果写入的数据自身就带逗号，需要进行处理 比如：123,234,234.00
                            //需要在数据前后再加双引号  “\”" +value+"\"",金额保留小数.00,有时候展示会缺失，可以加半角符号 “\”"+“\t” +value+"\""
                            buf.append(dataList.get(i).get(mapKeyArr[j])).append(CSV_COLUMN_SEPARATOR);
                        }
                    }
                    //一行数据写完，则需要换行
                    buf.append(CSV_RN);
                }
            }
            //写出响应
            os.write(buf.toString().getBytes("GBK"));
            os.flush();
            return true;
        } catch (Exception e) {
            logger.error("doExport错误===",e);
        }
      return false;


    }

    /**
     * 设置响应头和文件后缀信息
     *
     * @param fileName
     * @param response
     */
    public static void responseSetProperties(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        //设置文件后缀
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //文件名
        String fn = fileName + sdf.format(new Date()) + ".CSV";
        //读取字符编码
        String utf = "UTF-8";

        //设置响应
        response.setContentType("application/ms-txt.numberformat:@");
        response.setCharacterEncoding(utf);
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control", "max-age=30");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fn, utf));
    }

}
