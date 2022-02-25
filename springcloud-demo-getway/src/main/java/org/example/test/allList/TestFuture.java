package org.example.test.allList;
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
 
public class TestFuture {
 
	public List<String> test() throws InterruptedException, Exception{
		List<String> strList=new ArrayList<String>();
		List<Future<List<String>>> resultList=new ArrayList<Future<List<String>>>();
		ExecutorService exec=Executors.newCachedThreadPool();
		resultList.add(exec.submit(new strTask()));
		resultList.add(exec.submit(new strTask()));
		resultList.add(exec.submit(new strTask()));
		resultList.add(exec.submit(new strTask()));
		resultList.add(exec.submit(new strTask()));
		resultList.add(exec.submit(new strTask()));
		resultList.add(exec.submit(new numTask()));
		resultList.add(exec.submit(new numTask()));
		resultList.add(exec.submit(new numTask()));
		resultList.add(exec.submit(new numTask()));
		resultList.add(exec.submit(new numTask()));
		exec.shutdown();
		exec.awaitTermination(1,TimeUnit.DAYS);
		for(Future<List<String>> future:resultList){
			List<String> returnFuture=future.get();
			for(String s:returnFuture){
				strList.add(s);
			}
		}
		return strList;
	}
	
	class strTask implements Callable<List<String>>{
 
		@Override
		public List<String> call() throws Exception {
			List<String> strList=new ArrayList<String>();
			for(int i=0;i<10000;i++){
				Thread.sleep(1);
				strList.add("a"+i);
			}
			return strList;
		}
		
	}
	
	class numTask implements Callable<List<String>>{
 
		@Override
		public List<String> call() throws Exception {
			List<String> strList=new ArrayList<String>();
			for(int i=0;i<10000;i++){
				Thread.sleep(1);
				strList.add(String.valueOf(i));
			}
			return strList;
		}
		
	}

	public static void main(String[] args) throws Exception {
		TestFuture testFuture = new TestFuture();
		System.out.println(testFuture.test().size());
	}
}