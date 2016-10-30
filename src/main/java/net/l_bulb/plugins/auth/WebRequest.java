package net.l_bulb.plugins.auth;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.scheduler.BukkitRunnable;

public class WebRequest {

	static String _sreturn;
	public static String post(final String _url, final String parameter) {
		new BukkitRunnable() {
			public void run() {
				try {
					URL url = new URL(_url);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("POST");
					con.setConnectTimeout(5000);
					con.setUseCaches(false);
					con.setDoInput(true);
					con.setDoOutput(true);

					DataOutputStream wr = new DataOutputStream(con.getOutputStream());
					wr.writeBytes(parameter);
					wr.flush();
					wr.close();

				    InputStream is = con.getInputStream();
				    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
				    String line;
				    while ((line = rd.readLine()) != null) {
				        setReturn(line);
				      }
				    is.close();
					con.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}.runTaskAsynchronously(LBNAuth.getPlugin());
		return getReturn();

	}
	public static String get(final String _url) {
		new BukkitRunnable() {
			public void run() {
				try {
					URL url = new URL(_url);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.setConnectTimeout(5000);
					con.setUseCaches(false);
					con.setDoInput(true);
					con.setDoOutput(true);

				    InputStream is = con.getInputStream();
				    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
				    String line;
				    while ((line = rd.readLine()) != null) {
				    	setReturn(line);
				      }
				    is.close();
					con.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}.runTaskAsynchronously(LBNAuth.getPlugin());
		return getReturn();

	}
	static void setReturn(final String sreturn){
		_sreturn = sreturn;
	}

	static String getReturn(){
		return _sreturn;
	}
}
