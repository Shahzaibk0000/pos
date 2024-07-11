import com.mysql.cj.Session;
import entity.Product;
import service.ProductService;
import view.LoginView;
import view.MenuView;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;

public class main {
    public static void main(String[] args) throws InterruptedException {
        LoginView login = new LoginView();
        JFrame jFrame = login.getFrame();
        jFrame.setVisible(true);
    }
}

//
//public interface acceptable{
//        //some methods and members
//}

/*class Account{
    protected double amount;
    public void withDraw(double amount){
        this.amount = this.amount - amount;
    }
}

class SavingAccount{
    //member Functions
    public void display(){}
}

class CurrentAccount{
    public void display(){}
}

class User extends SavingAccount{
    @Override
    public void display() {
        super.display();
    }
}*/

/*public class main {
    public static void main(String[] args) {
        Temp temp = new Temp();
        temp.setA("java");
        System.out.println((String)temp.getA());
    }
}

class Temp{
    private Object a;

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }
}*/

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Objects;
//import java.util.Scanner;
//
//public class main {
//
//    public static void displayMenu() {
//        System.out.println("1) Add Student");
//        System.out.println("2) Display Student List");
//        System.out.println("3) Add Course");
//        System.out.println("4) Display Course");
//        System.out.println("5) Search Student by ID");
//        System.out.println("6) Search Student by Name");
//        System.out.println("7) Delete Student");
//        System.out.println("8) Exit");
//        System.out.println("Select: ");
//    }
//
//    public static void main(String[] args) {
//        ArrayList<Student> students = new ArrayList<Student>();
//
//        int select = '\0' , tempInteger = 0;
//        String name = null , address = null , tempString = null;
//        double cgpa = 0.0;
//        boolean tempFlag;
//
//        Scanner sc= new Scanner(System.in);
//
//        students.add(new Student("Shahzaib",3.13,"DGKHAN"));
//        students.add(new Student("Bilal",3.67,"Lahore"));
//        students.add(new Student("Amir",3.81,"Lahore"));
//        while(true) {
//            displayMenu();
//            select = sc.nextInt();
//            switch (select) {
//                case 1:
//                    System.out.println("Enter Name: ");
//                    sc.nextLine();
//                    name = sc.nextLine();
//                    System.out.println("Enter Cgpa: ");
//                    cgpa = sc.nextDouble();
//                    System.out.println("Enter Address: ");
//                    sc.nextLine();
//                    address = sc.nextLine();
//                    sc.nextLine();
//                    Student student = new Student(name,cgpa,address);
//                    students.add(student);
//                    break;
//                case 2:
//                    for(int i = 0 ; i < students.size() ; i++) {
//                        Student temp = students.get(i);
//                        System.out.println("Student " + i + ":-");
//                        System.out.println("ID: "  + temp.getId());
//                        System.out.println("Name: "  + temp.getName());
//                        System.out.println("Cgpa: "  + temp.getCgpa());
//                        System.out.println("Address: "  + temp.getAddress());
//                    }
//                    break;
//                case 3:
//                    System.out.println("Enter Id of Student: ");
//                    tempInteger = sc.nextInt();
//                    tempFlag = false;
//                    int i = 0;
//                    for (Student item : students) {
//                        if (tempInteger == item.getId()) {
//                            tempFlag = true;
//                            break;
//                        }
//                        i++;
//                    }
//                    if(tempFlag)
//                    {
//                        System.out.println("Enter Course Name: ");
//                        sc.nextLine();
//                        name = sc.nextLine();
//                        System.out.println("Enter Course ID: ");
//                        tempInteger = sc.nextInt();
//                        students.get(i).addCourse(tempInteger,name);
//                    }
//                    else
//                    {
//                        System.out.println("Student not Found");
//                    }
//
//                    break;
//                case 4:
//
//                    break;
//                case 5:
//                    System.out.println("Enter Id of Student: ");
//                    tempInteger = sc.nextInt();
//                    tempFlag = false;
//                    for (Student item : students) {
//                        if (tempInteger == item.getId()) {
//                            System.out.println("ID: " + item.getId());
//                            System.out.println("Name: " + item.getName());
//                            System.out.println("Cgpa: " + item.getCgpa());
//                            System.out.println("Address: " + item.getAddress());
//                            tempFlag = true;
//                            break;
//                        }
//                    }
//                    if(!tempFlag)
//                    {
//                        System.out.println("Student not Found in records");
//                    }
//                    break;
//                case 6:
//                    System.out.println("Enter Name of Student: ");
//                    sc.nextLine();
//                    tempString = sc.nextLine();
//                    tempFlag = false;
//                    for (Student value : students) {
//                        if (Objects.equals(tempString, value.getName())) {
//                            System.out.println("ID: " + value.getId());
//                            System.out.println("Name: " + value.getName());
//                            System.out.println("Cgpa: " + value.getCgpa());
//                            System.out.println("Address: " + value.getAddress());
//                            tempFlag = true;
//                            break;
//                        }
//                    }
//                    if(!tempFlag)
//                    {
//                        System.out.println("Student not Found in records");
//                    }
//                    break;
//                case 7:
//                    System.out.println("Enter Id of Student: ");
//                    tempInteger = sc.nextInt();
//                    tempFlag = false;
//                    for (Student item : students) {
//                        if (tempInteger == item.getId()) {
//                            students.remove(item);
//                            tempFlag = true;
//                            break;
//                        }
//                    }
//                    if(!tempFlag)
//                    {
//                        System.out.println("Student not Found in records");
//                    }
//                    else
//                    {
//                        System.out.println("Student deleted successfully");
//                    }
//                    break;
//                case 8:
//                    System.out.println("Program exited successfully");
//                    System.exit(0);
//                    break;
//            }
//        }
//    }
//}


//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//import java.io.StringWriter;
//import java.io.UnsupportedEncodingException;
//import java.io.Writer;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.logging.Formatter;
//import java.util.logging.Handler;
//import java.util.logging.Level;
//import java.util.logging.LogRecord;
//import java.util.logging.Logger;
//import java.util.regex.Pattern;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.CookieStore;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.protocol.ClientContext;
//import org.apache.http.client.utils.URIUtils;
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.impl.client.BasicCookieStore;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.protocol.BasicHttpContext;
//import org.apache.http.protocol.HttpContext;
//
//public class main {
//
//    public static String newline = System.getProperty("line.separator");
//    private static final Logger log = Logger.getLogger(main.class.getCanonicalName());
//    private static final Level defaultLogLevelSelf = Level.FINER;
//    private static final Level defaultLogLevel = Level.WARNING;
//    private static final Logger rootlog = Logger.getLogger("");
//    private static final String scheme = "http";
//    private static final String host = "www.youtube.com";
//    private static final Pattern commaPattern = Pattern.compile(",");
//    private static final Pattern pipePattern = Pattern.compile("\\|");
//    private static final char[] ILLEGAL_FILENAME_CHARACTERS = { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
//
//    private static void usage(String error) {
//        if (error != null) {
//            System.err.println("Error: " + error);
//        }
//        System.err.println("usage: JavaYoutubeDownload VIDEO_ID DESTINATION_DIRECTORY");
//        System.exit(-1);
//    }
//
//    public static void main(String[] args) {
////        if (args == null || args.length == 0) {
////            usage("Missing video id. Extract from https://www.youtube.com/watch?v=0ifpHv9AoLw");
////        }
//        try {
//            setupLogging();
//
//            log.fine("Starting");
//            String videoId = "0ifpHv9AoLw";
//            String outdir = "C:";
//            // TODO Ghetto command line parsing
////            if (args.length == 1) {
////                videoId = args[0];
////            } else if (args.length == 2) {
////                videoId = args[0];
////                outdir = args[1];
////            }
//
//            int format = 18; // http://en.wikipedia.org/wiki/YouTube#Quality_and_codecs
//            String encoding = "UTF-8";
//            String userAgent = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13";
//            File outputDir = new File(outdir);
//            String extension = getExtension(format);
//
//            play(videoId, format, encoding, userAgent, outputDir, extension);
//
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
//        log.fine("Finished");
//    }
//
//    private static String getExtension(int format) {
//        // TODO
//        return "mp4";
//    }
//
//    private static void play(String videoId, int format, String encoding, String userAgent, File outputdir, String extension) throws Throwable {
//        log.fine("Retrieving " + videoId);
//        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
//        qparams.add(new BasicNameValuePair("video_id", videoId));
//        qparams.add(new BasicNameValuePair("fmt", "" + format + "&html5=1&c=TVHTML5&cver=6.20180913"));
//        URI uri = getUri("get_video_info", qparams);
//
//        CookieStore cookieStore = new BasicCookieStore();
//        HttpContext localContext = new BasicHttpContext();
//        localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
//
//        HttpClient httpclient = new DefaultHttpClient();
//        HttpGet httpget = new HttpGet(uri);
//        httpget.setHeader("User-Agent", userAgent);
//
//        log.finer("Executing " + uri);
//        HttpResponse response = httpclient.execute(httpget, localContext);
//        HttpEntity entity = response.getEntity();
//        if (entity != null && response.getStatusLine().getStatusCode() == 200) {
//            InputStream instream = entity.getContent();
//            String videoInfo = getStringFromInputStream(encoding, instream);
//            if (videoInfo != null && videoInfo.length() > 0) {
//                List<NameValuePair> infoMap = new ArrayList<NameValuePair>();
//                URLEncodedUtils.parse(infoMap, new Scanner(videoInfo), encoding);
//                String token = null;
//                String downloadUrl = null;
//                String filename = videoId;
//
//                for (NameValuePair pair : infoMap) {
//                    String key = pair.getName();
//                    String val = pair.getValue();
//                    log.finest(key + "=" + val);
//                    if (key.equals("token")) {
//                        token = val;
//                    } else if (key.equals("title")) {
//                        filename = val;
//                    } else if (key.equals("fmt_url_map")) {
//                        String[] formats = commaPattern.split(val);
//                        for (String fmt : formats) {
//                            String[] fmtPieces = pipePattern.split(fmt);
//                            if (fmtPieces.length == 2) {
//                                // in the end, download somethin!
//                                downloadUrl = fmtPieces[1];
//                                int pieceFormat = Integer.parseInt(fmtPieces[0]);
//                                if (pieceFormat == format) {
//                                    // found what we want
//                                    downloadUrl = fmtPieces[1];
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//
//                filename = cleanFilename(filename);
//                if (filename.length() == 0) {
//                    filename = videoId;
//                } else {
//                    filename += "_" + videoId;
//                }
//                filename += "." + extension;
//                File outputfile = new File(outputdir, filename);
//
//                if (downloadUrl != null) {
//                    downloadWithHttpClient(userAgent, downloadUrl, outputfile);
//                }
//            }
//        }
//    }
//
//    private static void downloadWithHttpClient(String userAgent, String downloadUrl, File outputfile) throws Throwable {
//        HttpGet httpget2 = new HttpGet(downloadUrl);
//        httpget2.setHeader("User-Agent", userAgent);
//
//        log.finer("Executing " + httpget2.getURI());
//        HttpClient httpclient2 = new DefaultHttpClient();
//        HttpResponse response2 = httpclient2.execute(httpget2);
//        HttpEntity entity2 = response2.getEntity();
//        if (entity2 != null && response2.getStatusLine().getStatusCode() == 200) {
//            long length = entity2.getContentLength();
//            InputStream instream2 = entity2.getContent();
//            log.finer("Writing " + length + " bytes to " + outputfile);
//            if (outputfile.exists()) {
//                outputfile.delete();
//            }
//            FileOutputStream outstream = new FileOutputStream(outputfile);
//            try {
//                byte[] buffer = new byte[2048];
//                int count = -1;
//                while ((count = instream2.read(buffer)) != -1) {
//                    outstream.write(buffer, 0, count);
//                }
//                outstream.flush();
//            } finally {
//                outstream.close();
//            }
//        }
//    }
//
//    private static String cleanFilename(String filename) {
//        for (char c : ILLEGAL_FILENAME_CHARACTERS) {
//            filename = filename.replace(c, '_');
//        }
//        return filename;
//    }
//
//    private static URI getUri(String path, List<NameValuePair> qparams) throws URISyntaxException {
//        URI uri = URIUtils.createURI(scheme, host, -1, "/" + path, URLEncodedUtils.format(qparams, "UTF-8"), null);
//        return uri;
//    }
//
//    private static void setupLogging() {
//        changeFormatter(new Formatter() {
//            @Override
//            public String format(LogRecord arg0) {
//                return arg0.getMessage() + newline;
//            }
//        });
//        explicitlySetAllLogging(Level.FINER);
//    }
//
//    private static void changeFormatter(Formatter formatter) {
//        Handler[] handlers = rootlog.getHandlers();
//        for (Handler handler : handlers) {
//            handler.setFormatter(formatter);
//        }
//    }
//
//    private static void explicitlySetAllLogging(Level level) {
//        rootlog.setLevel(Level.ALL);
//        for (Handler handler : rootlog.getHandlers()) {
//            handler.setLevel(defaultLogLevelSelf);
//        }
//        log.setLevel(level);
//        rootlog.setLevel(defaultLogLevel);
//    }
//
//    private static String getStringFromInputStream(String encoding, InputStream instream) throws UnsupportedEncodingException, IOException {
//        Writer writer = new StringWriter();
//
//        char[] buffer = new char[1024];
//        try {
//            Reader reader = new BufferedReader(new InputStreamReader(instream, encoding));
//            int n;
//            while ((n = reader.read(buffer)) != -1) {
//                writer.write(buffer, 0, n);
//            }
//        } finally {
//            instream.close();
//        }
//        String result = writer.toString();
//        return result;
//    }
//}

/*
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) {
        sendMail(new Exception("Problem with cable"));
    }

    public static void sendMail(Exception exception) {
        String to = "destination@test.com";
        String from = "sender@test.com";
        String host = "smtp.test.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Trade-processor instance shutdown!");
            message.setText(getExceptionMessage(exception));
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private static String getExceptionMessage(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}*/