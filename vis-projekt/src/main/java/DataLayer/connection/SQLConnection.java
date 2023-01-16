package DataLayer.connection;

public class SQLConnection{

	public String getConnection()
	{
			  String url = "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;"
                    + "database=VIL0086;"
                    + "user=vil0086;"
                    + "password=OK4ns5J3LG6r8EQu;"
                    + "encrypt=false;"
                    + "trustServerCertificate=false;"
                    + "loginTimeout=30;";
			  return url;
	}
}