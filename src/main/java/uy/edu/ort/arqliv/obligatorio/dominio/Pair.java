package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;
/**
 * Clase generica 
 * @author mauricio
 *
 * @param <K>
 * @param <V>
 */
public class Pair<K, V> implements Serializable{

	private static final long serialVersionUID = 1935058994887873346L;
	
	private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public Pair() {

    }

	public K getKey()   { 
    	return key; 
    }

    public void setKey(K key) { 
    	this.key = key; 
    }
    
    public V getValue() { 
    	return value; 
    }
    
    public void setValue(V value) { 
    	this.value = value; 
    }

	@Override
	public String toString() {
		return "Servicio:" + key + ", Tiempo:" + value;
	}
    
}
