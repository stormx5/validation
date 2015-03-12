package valifation_Project.validation;

import com.dropbox.core.*;

import java.util.Locale;
import java.io.*;

public class DropBoxAPI {
	final String app_key = "9jfughgbhubbnsf";
	final String app_secret = "zfgn6o6ial7552o";
	
	public boolean CheckDropboxAPI() throws IOException, DbxException{
		DbxAppInfo appinfo = new DbxAppInfo(app_key, app_secret);
		
		DbxRequestConfig config = new DbxRequestConfig("CS585Test", Locale.getDefault().toString());
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appinfo);
        String authorizeUrl = webAuth.start();
        System.out.println(authorizeUrl);
        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
        DbxAuthFinish authFinish = webAuth.finish(code);
        String accessToken = authFinish.accessToken;

        DbxClient client = new DbxClient(config, accessToken);

        System.out.println("Linked account: " + client.getAccountInfo().displayName);
        
        long dropboxsize = -1;
        DbxAccountInfo acctinfo = client.getAccountInfo();
        dropboxsize = acctinfo.quota.total / 1024 / 1024 / 1024;
        
        if(dropboxsize > 0)
        {
        	return true;
        }
        else
        	return false;

	}

}
