

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import oracle.jdbc.pool.OraclePooledConnection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class GetDbConn {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    OraclePooledConnection pc = null;
    Connection con = null;
    
    public GetDbConn(){ con=null;}

    public Connection GetdbConnection(String is_filename, String is_section) {

        String ls_driver = "", ls_jdbc = "", ls_ip = "", ls_host = "";
        String ls_login = "", ls_pass = "", ls_db = "";
        NodeList nList = null;

        try {

            File fXmlFile = new File(is_filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            //  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            //   System.out.println(is_filename);
            nList = doc.getElementsByTagName(is_section);

            //   System.out.println("-----------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    ls_db = getTagValue("DataBase", eElement);
                    ls_driver = getTagValue("Driver", eElement);
                    ls_jdbc = getTagValue("JDBCurl", eElement);
                    ls_ip = getTagValue("IP", eElement);
                    ls_host = getTagValue("HOST", eElement);
                    ls_login = getTagValue("Login", eElement);
                    ls_pass = getTagValue("Pass", eElement);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            Class c = Class.forName(ls_driver);
            Driver driver = (Driver) c.newInstance();
            DriverManager.registerDriver(driver);

            //String ls_url = ls_login + "@//" + ls_ip + ":" + ls_host + "/xe";
           //String ls_url = ls_jdbc + ":@" + ls_ip + ":" + ls_host;
            String ls_url = "jdbc:oracle:thin:@localhost:1521:xe";
            if (ls_db.toUpperCase().equals("ORACLE")) {
                //      OraclePooledConnection pc=new OraclePooledConnection("jdbc:oracle:thin:@10.10.0.4:1521:glob","eipldba","eiplubq");

                if (pc == null) {
                    System.out.println("pooling");
                    //pc = new OraclePooledConnection(ls_url, ls_login, ls_pass);
                    pc = new OraclePooledConnection(ls_url, "poltest", "pol123");
                }
                
                con = pc.getConnection();
                

            } else if (ls_db.toUpperCase().equals("SYBASE")) {
                con = DriverManager.getConnection(ls_jdbc + ":" + ls_ip + "?ServiceName=" + ls_host, ls_login, ls_pass);
            }
            Calendar calx = Calendar.getInstance();
            System.out.println((new StringBuilder()).append("---------------------------------------------------Start Connection:: ").append(is_section).append("::").append(sdf.format(calx.getTime())).toString());
        } catch (Exception conex) {
            conex.printStackTrace();
        }

        return con;

    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();
    }

    public void closeConnection(Connection conn, ResultSet rs, Statement stmt, PreparedStatement pstmt) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            System.out.println("GetDbConn -- ResultSet Closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            System.out.println("GetDbConn --Statement Closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            System.out.println("GetDbConn --PreparedStatement Closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }

            System.out.println("GetDbConn -- Connection Closed.");
            Calendar caly = Calendar.getInstance();
            System.out.println((new StringBuilder()).append("---------------------------------------------------End Connection :: ").append(sdf.format(caly.getTime())).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
            System.out.println("GetDbConn -- Connection Closed.");
            Calendar caly = Calendar.getInstance();
            System.out.println((new StringBuilder()).append("---------------------------------------------------End Connection :: ").append(sdf.format(caly.getTime())).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




/*public static void main(String[] args)
{             
    
    
    linkedList list = new linkedList(); 







/*public class PolConnect {
	
	  
	 
	 public Connection GetConnection()
	 {  
	  try{  
		  
		  Class c=Class.forName(ls_driver);
	   //step1 load the driver class  
	   Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	   //step2 create  the connection object  
	   Connection con=DriverManager.getConnection(  
	   "jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
	  
	   //step3 create the statement object  
	   Statement stmt=con.createStatement();  
	  
	   //step4 execute query  
	   ResultSet rs=stmt.executeQuery("select * from ASSEMBLY_MASTER ");  
	   while(rs.next())  
	   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	     
	   //step5 close the connection object  
	   con.close();  
	  
	  }catch(Exception e){ 
	   System.out.println(e);
	  }  
	  
	 }  
	}

}*/
