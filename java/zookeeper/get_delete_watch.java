package eeeeeee;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.KeeperException.NodeExistsException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class Zookeeper_Constructor_Usage_Simple implements Watcher {
	private static Semaphore connectedSemaphore = new Semaphore(0);

	@Override
	public void process(WatchedEvent event) {
		System.out.println("Receive watched event : " + event);
		if (KeeperState.SyncConnected == event.getState()) {
			connectedSemaphore.release();
		}
		if (event.getType() == EventType.NodeDeleted) {
			connectedSemaphore.release();
		}

	}

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zookeeper = new ZooKeeper("100.107.49.78:2181", 5000, new Zookeeper_Constructor_Usage_Simple());

		System.out.println(zookeeper.getState());
		ACL zz = new ACL();
		List<ACL> acl = new LinkedList();
		acl.add(zz);
		String s1 = new String("CONNECTED");

		connectedSemaphore.acquire();
		
		for(String s : zookeeper.getChildren("/", false)) {
			if(!s.equals("zookeeper"))
			zookeeper.delete("/" + s, 0);
		}

		for (int i = 0; i < 10; i++) {

			try {
				zookeeper.create("/zhaojinzhou" + i, ("zhaojinzhou"+i).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
						CreateMode.PERSISTENT);
			} catch (NodeExistsException e) {

				String s = new String(zookeeper.getData("/zhaojinzhou" + i, true, null));
				System.out.println(s);
				zookeeper.delete("/zhaojinzhou" + i, 1);
				
				connectedSemaphore.acquire();
				connectedSemaphore.acquire();

				zookeeper.create("/zhaojinzhou" + i, ("zhaojinzhou"+i).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
						CreateMode.PERSISTENT);
				System.out.println("zhhhhh");

			}
			if (i == 9)
				System.out.println(zookeeper.getChildren("/", false));
		}

		zookeeper.close();

	}
}
