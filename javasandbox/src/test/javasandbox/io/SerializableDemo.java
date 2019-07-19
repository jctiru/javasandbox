package test.javasandbox.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableDemo {
	// By convention, static nested classes should be placed before static methods
	public static class SerializableClass implements Serializable {
		static final long serialVersionUID = 8882416210786165012L;
		private String name;
//		private String gender;
		private transient int id = 4;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

	}

	public static void main(String[] args) {
		if (args.length > 0 && args[0].equals("true")) {
			new SerializableDemo().doSerialization();
		}
		new SerializableDemo().doDeserialization();
	}

	private void doSerialization() {
		System.out.println("\nInside doSerialization ...");
		SerializableClass serializableClass = new SerializableClass();
		serializableClass.setName("Java");
		System.out.println("name (before serialization): " + serializableClass.getName());
		System.out.println("id (before serialization): " + serializableClass.getId());

		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("serial.ser")))) {
			out.writeObject(serializableClass);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doDeserialization() {
		System.out.println("\nInside doDeserialization ...");

		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("serial.ser")))) {
			SerializableClass serializedObj = (SerializableClass) in.readObject();
			System.out.println("name (after deserialization): " + serializedObj.getName());
			System.out.println("id (after deserialization): " + serializedObj.getId());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
