import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManagement implements Runnable{
	
	protected String catalogFrom;
	protected String catalogTo;
	protected int n;

	
	public FileManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public FileManagement(String catalogFrom, String catalogTo) {
		super();
		this.catalogFrom = catalogFrom;
		this.catalogTo = catalogTo;
	}
	
	public FileManagement(String catalogFrom, String catalogTo, int n) {
		super();
		this.catalogFrom = catalogFrom;
		this.catalogTo = catalogTo;
		this.n = n;
	}



	protected void copyFileFromCatalog (String catalogFrom, String catalogTo){
		
		//создаем объект from каталога, с которого будем коприровать
		File from = new File(catalogFrom);
		
		
		// получаем список файлов из каталога from
		File[] fileList = from.listFiles();
		
		for (int i = 0; i < fileList.length; i++) {
			// копируем все файлы из filelist
			try(
					FileInputStream fis = new FileInputStream( catalogFrom + "/" +fileList[i].getName());
					FileOutputStream fos = new FileOutputStream(catalogTo + "/" + fileList[i].getName())) {
					byte[] buffer = new byte[1024];
					int byteread = 0;
					for (; (byteread = fis.read(buffer)) > 0;) {
					fos.write(buffer, 0, byteread);
					}
					} catch (IOException e) {
						System.out.println(e);
						}
		}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread thr = Thread.currentThread();
		for (int i = 1; i < this.n; i++) {
			copyFileFromCatalog(catalogFrom,catalogTo);
			System.out.println(thr.getName());
		}
		
		
		
	}
	
	
	
}
