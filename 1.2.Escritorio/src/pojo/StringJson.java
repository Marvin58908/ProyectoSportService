package pojo;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class StringJson {
	//Sinlegton
	public static StringJson _Instancia;
	private StringJson() {};
	public static StringJson Instancia() {
		if(_Instancia==null) {
			_Instancia = new StringJson();
		}
		return _Instancia;
	}
	public Usuario ExtraeJsonVerificarAcceso(String URL) {
		String chunk=null;
		Usuario u = null;
		HttpClient httpClient = new DefaultHttpClient();
	    try {
	      HttpGet httpGetRequest = new HttpGet(URL);
	      HttpResponse httpResponse = httpClient.execute(httpGetRequest);
	      HttpEntity entity = httpResponse.getEntity();
	      byte[] buffer = new byte[1024];
	      if (entity != null) {
	        InputStream inputStream = entity.getContent();
	        try {
	          int bytesRead = 0;
	          BufferedInputStream bis = new BufferedInputStream(inputStream);
	          if ((bytesRead = bis.read(buffer)) != -1) {
	            chunk = new String(buffer, 0, bytesRead);
	            ObjectMapper mapper = new ObjectMapper();
	            u = mapper.readValue(chunk, new TypeReference<Usuario>(){});
	          }
	        } catch (IOException ioException) {
	          ioException.printStackTrace();
	        } catch (RuntimeException runtimeException) {
	          httpGetRequest.abort();
	          runtimeException.printStackTrace();
	        } finally {
	          try {
	            inputStream.close();
	          } catch (Exception ignore) {
	          }
	        }
	      }
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      httpClient.getConnectionManager().shutdown();
	    }	
	    return u;
	}
	public ArrayList<Contacto> ExtraeJsonListarContacto(String URL) {
		String chunk=null;
		ArrayList<Contacto> lista = null;
		HttpClient httpClient = new DefaultHttpClient();
	    try {
	      HttpGet httpGetRequest = new HttpGet(URL);
	      HttpResponse httpResponse = httpClient.execute(httpGetRequest);
	      HttpEntity entity = httpResponse.getEntity();
	      byte[] buffer = new byte[99999999];
	      if (entity != null) {
	        InputStream inputStream = entity.getContent();
	        try {
	          int bytesRead = 0;
	          BufferedInputStream bis = new BufferedInputStream(inputStream);
	          if ((bytesRead = bis.read(buffer)) != -1) {
	            chunk = new String(buffer, 0, bytesRead);
	            ObjectMapper mapper = new ObjectMapper();
	            lista = mapper.readValue(chunk, new TypeReference<ArrayList<Contacto>>(){});
	          }
	        } catch (IOException ioException) {
	          ioException.printStackTrace();
	        } catch (RuntimeException runtimeException) {
	          httpGetRequest.abort();
	          runtimeException.printStackTrace();
	        } finally {
	          try {
	            inputStream.close();
	          } catch (Exception ignore) {
	          }
	        }
	      }
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      httpClient.getConnectionManager().shutdown();
	    }	
	    return lista;
	}
	
	public Contacto ExtraeJsonInsertarContacto(String URL) {
		String chunk=null;
		Contacto c = null;
		HttpClient httpClient = new DefaultHttpClient();
	    try {
	      HttpGet httpGetRequest = new HttpGet(URL);
	      HttpResponse httpResponse = httpClient.execute(httpGetRequest);
	      HttpEntity entity = httpResponse.getEntity();
	      byte[] buffer = new byte[1024];
	      if (entity != null) {
	        InputStream inputStream = entity.getContent();
	        try {
	          int bytesRead = 0;
	          BufferedInputStream bis = new BufferedInputStream(inputStream);
	          if ((bytesRead = bis.read(buffer)) != -1) {
	            chunk = new String(buffer, 0, bytesRead);
	            ObjectMapper mapper = new ObjectMapper();
	            c = mapper.readValue(chunk, new TypeReference<Contacto>(){});
	          }
	        } catch (IOException ioException) {
	          ioException.printStackTrace();
	        } catch (RuntimeException runtimeException) {
	          httpGetRequest.abort();
	          runtimeException.printStackTrace();
	        } finally {
	          try {
	            inputStream.close();
	          } catch (Exception ignore) {
	          }
	        }
	      }
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      httpClient.getConnectionManager().shutdown();
	    }	
	    return c;
	}
	public Usuario ExtraeJsonInsertarUsuario(String URL) {
		String chunk=null;
		Usuario u= null;
		HttpClient httpClient = new DefaultHttpClient();
	    try {
	      HttpGet httpGetRequest = new HttpGet(URL);
	      HttpResponse httpResponse = httpClient.execute(httpGetRequest);
	      HttpEntity entity = httpResponse.getEntity();
	      byte[] buffer = new byte[1024];
	      if (entity != null) {
	        InputStream inputStream = entity.getContent();
	        try {
	          int bytesRead = 0;
	          BufferedInputStream bis = new BufferedInputStream(inputStream);
	          if ((bytesRead = bis.read(buffer)) != -1) {
	            chunk = new String(buffer, 0, bytesRead);
	            ObjectMapper mapper = new ObjectMapper();
	            u = mapper.readValue(chunk, new TypeReference<Contacto>(){});
	          }
	        } catch (IOException ioException) {
	          ioException.printStackTrace();
	        } catch (RuntimeException runtimeException) {
	          httpGetRequest.abort();
	          runtimeException.printStackTrace();
	        } finally {
	          try {
	            inputStream.close();
	          } catch (Exception ignore) {
	          }
	        }
	      }
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      httpClient.getConnectionManager().shutdown();
	    }	
	    return u;
	}
}
