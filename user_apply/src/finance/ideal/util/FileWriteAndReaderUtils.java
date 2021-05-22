package finance.ideal.util;

import finance.ideal.domain.Applicant;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
* 文件的读写
*/
public class FileWriteAndReaderUtils {
    public  int result=0;
    Utils util;
    public final  Map businissNameMap = new HashMap();
   {
       businissNameMap.put("PersonalLoancount", "DK");
       businissNameMap.put("PersonalOperatorcount", "DX");
       businissNameMap.put("enterprisecount", "QY");
       businissNameMap.put("NetLoancount", "WD");
    }

    /**
     * 读取流中前面的字符，看是否有bom，如果有bom，将bom头先读掉丢弃
     *
     * @param in
     * @return
     * @throws java.io.IOException
     */
    public static InputStream getInputStream(InputStream in) throws IOException {

        PushbackInputStream testin = new PushbackInputStream(in);
        int ch = testin.read();
        if (ch != 0xEF) {
            testin.unread(ch);
        } else if ((ch = testin.read()) != 0xBB) {
            testin.unread(ch);
            testin.unread(0xef);
        } else if ((ch = testin.read()) != 0xBF) {
            throw new IOException("错误的UTF-8格式文件");
        }
        return testin;
    }

    /**
     * 读取文件
     * @param savedFile
     * @param batchno
     * @param time
     * @param Businessvalue
     * @return
     */
    public List<String[]> FileWrite(File savedFile,String batchno,String time,Map<String, String> Businessvalue){
        // TODO: 2018/12/18
        BufferedReader reader = null;
        ArrayList<String[]> list= new ArrayList<String[]>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            InputStreamReader isr = new InputStreamReader(getInputStream(new FileInputStream(savedFile)), "utf-8");
            reader = new BufferedReader(isr);
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号

                String[] split = tempString.split(",");
                if ("模板文件".equals(split[0])||"姓名".equals(split[0])||"手机号".equals(split[1])) {
                }else {
                    list.add(split);
                    result++;
                }

            }
            Utils utils = new Utils();
            System.out.println(result);
            utils.insertCount(result,batchno,time,Businessvalue.get("userName"),Businessvalue.get("tableName"));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }

    /*
    * 写文件
    */

    public void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, false);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //下载文件
    public void download(HttpServletRequest request, HttpServletResponse response,String jsp,String id,String path)
            throws IOException, ServletException {
        String filename = id+".csv";
        System.out.println(filename);
        File file = new File(path);
        if (file.exists()) {
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
//            outputStream.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });// 加入BOM防止出现中文乱码的情况
            byte[] b = new byte[1024];
            int n ;
            while((n = inputStream.read(b))!=-1){
                outputStream.write(b, 0, n);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("文件下载完成");
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
            dispatcher.forward(request, response);
        }
    }
    public void downloadxls(HttpServletRequest request, HttpServletResponse response,String jsp,String id,String path)
            throws IOException, ServletException {
        String filename = id+".xls";
        System.out.println(filename);
        File file = new File(path);
        if (file.exists()) {
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
//            outputStream.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });// 加入BOM防止出现中文乱码的情况
            byte[] b = new byte[1024];
            int n ;
            while((n = inputStream.read(b))!=-1){
                outputStream.write(b, 0, n);
            }
            outputStream.close();
            inputStream.close();
            System.out.println("文件下载完成");
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
            dispatcher.forward(request, response);
        }
    }
//
//    /**
//     * 读取网页上传文件并且调用
//     * @param request
//     * @param response
//     */
//    public void ReadNetFile(HttpServletRequest request, HttpServletResponse response,Map<String, String> Businessvalue){
//        try {
//            // Create a factory for disk-based file items
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            util=new Utils();
//
//            // Set factory constraints
//            factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
//            factory.setRepository(tempPathFile);// 设置缓冲区目录
//
//            // Create a new file upload handler
//            ServletFileUpload upload = new ServletFileUpload(factory);
//
//            // Set overall request size constraint
//            upload.setSizeMax(41943040); // 设置最大文件尺寸，这里是4MB
//
//            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
//            Iterator<FileItem> i = items.iterator();
//            FileWriteAndReaderUtils fwr = new FileWriteAndReaderUtils();
//
//            System.out.println("正在上传");
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String time = df.format(new Date());
//            final String batchno= Businessvalue.get("userName")+String.valueOf(System.currentTimeMillis());
//            while (i.hasNext()) {
//                FileItem fi = (FileItem) i.next();
//                String fileName = fi.getName();
//                if (fileName != null) {
//                    File savedFile = new File(uploadPath,new String("prttyloan".getBytes(), "utf-8"));
//                    fi.write(savedFile);//写文件
//                    System.out.println(batchno);
//                    List<String[]> list = fwr.FileWrite(savedFile,batchno,time,Businessvalue);//读文件然后调用业务
//
//                    Applicant ap = new Applicant();
//
//                    for (int j = 0; j <list.size(); j++) {
//                        String[] file = list.get(j);//新建一个文件类
//
//
//                    }
//
//                }
//            }
//            System.out.print("文件上传完成");
//        } catch (Exception e) {
//
//        }
//    }


    /**
     * 读取网页上传文件并且调用
     * @param request
     * @param response
     * @param Businessvalue
     * @throws IOException
     */
    public void ReadNetFile(HttpServletRequest request,
                         HttpServletResponse response,Map<String, String> Businessvalue) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        util=new Utils();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding(request.getCharacterEncoding());

        ExcelOperate excelOperate = new ExcelOperate();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        //得到用户名的前3位
        String userType=Businessvalue.get("userName");
        if (userType.length() <= 2) {
            userType=userType.substring(0,2);
        }
        String batchno= businissNameMap.get(Businessvalue.get("tableName")) + "-" + String.valueOf(System.currentTimeMillis()) + "-" + userType; // 流水号
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (int i = 0; i < list.size(); i++) {
                FileItem item = list.get(i);
                if (item.getName().endsWith(".xls")||item.getName().endsWith(".xlsx")) {
                    // 说明是文件,不过这里最好限制一下
                    //helper.importXls(item.getInputStream());
                    List<String[]> data = excelOperate.getData(item.getInputStream(), 0);
                    int rowLength = data.size();
                    result=rowLength;

                    for(int k=0;k<rowLength;k++) {
                        String[] file = data.get(k);
                        Applicant ap = new Applicant();
                            System.out.println(file.length);
                            if ("模板文件".equals(file[0])||"姓名".equals(file[0])||"名称".equals(file[0])){
                                result--;
                            }else{
                                ap.setUname(file[0]);
                                ap.setUphone(file[1]);
                                ap.setIdnumber(file[2]);
                                ap.setAddress(file[3]);
                                ap.setPeople(file[4]);
                                ap.setDwname(file[5]);
                                ap.setDwphone(file[6]);
                                ap.setMoney(file[7]);
                                ap.setWork(file[8]);
                                ap.setYt(file[9]);
                                ap.setLy(file[10]);
                                ap.setOrdernum("single_loan"+String.valueOf(System.currentTimeMillis()));
                                ap.setServietype(Businessvalue.get("tableName"));
                                ap.setBankcard(file[11]);
                                ap.setBatchno(batchno);

                                final String modelType = Businessvalue.get("modeltype");
                                ap.setModeltype(Businessvalue.get("tableName"));
                                System.out.println("流水号"+util.turnBusinessType(modelType));
                                AssessmentRequestUtil.getRequest(ap,util.turnBusinessType(modelType));
                                Thread.sleep(5000);

                        }
                    }
                    util.insertCount(result,batchno,time,Businessvalue.get("userName"),Businessvalue.get("tableName"));// 将总数插入库中
                    out.write("{\"result\":\"OK\"}");
                } else {
                    // 说明文件格式不符合要求
                    out.write("{\"result\":\"Invalid\"}");
                }
            }
            out.flush();
            out.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
