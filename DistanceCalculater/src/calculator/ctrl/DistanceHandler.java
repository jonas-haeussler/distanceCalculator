package calculator.ctrl;

import java.util.LinkedList;
import java.util.Map;

import org.openstreetmap.osmosis.core.container.v0_6.EntityContainer;
import org.openstreetmap.osmosis.core.domain.v0_6.Entity;
import org.openstreetmap.osmosis.core.domain.v0_6.Node;
import org.openstreetmap.osmosis.core.domain.v0_6.Relation;
import org.openstreetmap.osmosis.core.domain.v0_6.Way;
import org.openstreetmap.osmosis.core.task.v0_6.Sink;

import calculator.data.Adress;

public class DistanceHandler {
	
	private LinkedList<Adress> adresses;
	private byte carSize;
	
	public DistanceHandler(byte carSize) {
		adresses = new LinkedList<>();
		this.carSize = carSize;
	}
	public Adress getAdress(int i) {
		return adresses.get(i);
	}
	public void addAdress(Adress a) {
		adresses.add(a);
	}
	public int getSize() {
		return adresses.size();
		}
	public LinkedList<Adress> getAdressList() {
		return adresses;
		}
	}
