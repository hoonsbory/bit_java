package day19;

public class Node<E> {
			E data;
			Node<E> next;  //다음 데이터의 위치를 알려줌. 다음 데이터타입도 E
			
			public Node(E data, Node<E> next) {
				super();
				this.data = data;
				this.next = next;
			}

			@Override
			public String toString() {
				return "Node [data=" + data + ", next=" + next + "]";
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((data == null) ? 0 : data.hashCode());
				result = prime * result + ((next == null) ? 0 : next.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Node other = (Node) obj;
				if (data == null) {
					if (other.data != null)
						return false;
				} else if (!data.equals(other.data))
					return false;
				if (next == null) {
					if (other.next != null)
						return false;
				} else if (!next.equals(other.next))
					return false;
				return true;
			}
			
			
}
