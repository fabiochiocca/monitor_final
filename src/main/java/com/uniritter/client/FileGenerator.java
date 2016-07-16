package com.uniritter.client;

public class FileGenerator{
	
	Trace trace = new Trace();
	private ThreadFileGenerator thdFileGenerator;
	
	public FileGenerator() {
		this.thdFileGenerator = new ThreadFileGenerator();
	}
	
	class ThreadFileGenerator implements Runnable {
		
		Consumer client = new Consumer();
		
		public ThreadFileGenerator() {
		}
		
		@Override
		public void run() {
			while(true){
				String parameter = null;
				String response = null;
				try{			
					parameter = trace.readArchive();
				}catch(Throwable t){
					trace.writeFile(t);
				}
				if(parameter!=null && !parameter.trim().equals("")){
					switch (parameter) {
					case "all_metrics":
						response = client.getMetricas(); 
						break;
					default:
						response = client.getMetrica(parameter);
						break;
					}
				}
				if(response!=null){
					try{
						trace.writeArchive(response);
					}catch(Throwable t){
						trace.writeFile(t);
					}
				}else{
					if(!parameter.trim().equals("")){
						try{
							trace.writeArchive("Ocorreu um erro de integração");
						}catch(Throwable t){
							trace.writeFile(t);
						}
					}
				}
				try{
					Thread.sleep(10000);
				}catch(Throwable t){
				}
			}
		}

	}
	
	public static void main(String[] args) {
		
		FileGenerator fileGenerator = new FileGenerator();
		fileGenerator.thdFileGenerator.run();
		
	}
	

}
