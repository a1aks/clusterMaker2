package edu.ucsf.rbvi.clusterMaker2.internal.algorithms.networkClusterers.GLay;

import java.util.Collections;
import java.util.List;

//Cytoscape imports
import org.cytoscape.work.TaskIterator;


import edu.ucsf.rbvi.clusterMaker2.internal.algorithms.AbstractClusterTaskFactory;
import edu.ucsf.rbvi.clusterMaker2.internal.api.ClusterManager;
import edu.ucsf.rbvi.clusterMaker2.internal.api.ClusterTaskFactory;
import edu.ucsf.rbvi.clusterMaker2.internal.api.ClusterTaskFactory.ClusterType;
import edu.ucsf.rbvi.clusterMaker2.internal.api.ClusterViz;

public class GLayClusterTaskFactory extends AbstractClusterTaskFactory {
	ClusterManager clusterManager;
	GLayContext context = null;
	
	public GLayClusterTaskFactory(ClusterManager clusterManager) {
		context = new GLayContext();
		this.clusterManager = clusterManager;
	}
	
	public String getShortName() {return GLayCluster.SHORTNAME;};
	public String getName() {return GLayCluster.NAME;};

	public ClusterViz getVisualizer() {
		// return new NewNetworkView(true);
		return null;
	}

	public boolean isReady() {
		return true;
	}

	public List<ClusterType> getTypeList() {
		return Collections.singletonList(ClusterType.NETWORK); 
	}

	public TaskIterator createTaskIterator() {
		// Not sure why we need to do this, but it looks like
		// the tunable stuff "remembers" objects that it's already
		// processed this tunable.  So, we use a copy constructor
		return new TaskIterator(new GLayCluster(context, clusterManager));
	}
	
}
	
	



