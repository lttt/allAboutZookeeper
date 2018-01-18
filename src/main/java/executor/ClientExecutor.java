package executor;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ClientExecutor implements ExecutorService {
	
	
	private final ExecutorService realExecutor=Executors.newFixedThreadPool(500);

	public void execute(Runnable command) {
		realExecutor.equals(command);

	}

	public void shutdown() {
		realExecutor.shutdown();
		
	}

	public List<Runnable> shutdownNow() {
		
		return realExecutor.shutdownNow();
	}

	public boolean isShutdown() {
		return realExecutor.isShutdown();
	}

	public boolean isTerminated() {
		return realExecutor.isTerminated();
	}

	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		return realExecutor.awaitTermination(timeout, unit);
	}

	public <T> Future<T> submit(Callable<T> task) {
		return realExecutor.submit(task);
	}

	public <T> Future<T> submit(Runnable task, T result) {
		return realExecutor.submit(task,result);
	}

	public Future<?> submit(Runnable task) {
		return realExecutor.submit(task);
	}

	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
		return realExecutor.invokeAll(tasks);
	}

	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}

}
