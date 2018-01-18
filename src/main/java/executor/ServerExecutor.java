package executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ServerExecutor implements Executor{
	
	
	private final Executor realExecutor=Executors.newFixedThreadPool(30);

	public void execute(Runnable command) {
		realExecutor.equals(command);

	}

}
