package tree;

// 2진 트리
public class BinaryTree {

    public int count; // 총 노드의 개수

    public BinaryTree() {
        count = 0;
    }

    public class Node {
        public Object data;
        public Node right;
        public Node left;

        public Node(Object data) {
            this.data = data;
            right = null;
            left = null;
        }

        /* 현재 노드의 좌측에 노드 연결 */
        public void addLeft(Node node) {
            this.left = node;
            count++;
        }

        /* 현재 노드의 우측에 노드 연결 */
        public void addRight(Node node) {
            this.right = node;
            count++;
        }

        /* 현재 노드의 좌측에 노드 삭제 */
        public void deleteLeft() {
            this.left = null;
            count--;
        }

        /* 현재 노드의 우측에 노드 삭제 */
        public void deleteRight() {
            this.right = null;
            count--;
        }
    }

    /* 노드 새롭게 생성 */
    public Node addNode(Object data) {
        return new Node(data);
    }

    /* 전위 순회 방법 이용 후 출력 */
    public void preOrder(Node node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /* 중위 순회 방법 이용 후 출력 */
    public void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /* 후위 순회 방법 이용 후 출력 */
    public void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void run() {
        BinaryTree tree = new BinaryTree();

        //    1
        //  2    3
        // 4 5  6 7

        // 이진 트리 생성
        Node node1 = tree.addNode(1);
        Node node2 = tree.addNode(2);
        Node node3 = tree.addNode(3);
        Node node4 = tree.addNode(4);
        Node node5 = tree.addNode(5);
        Node node6 = tree.addNode(6);
        Node node7 = tree.addNode(7);

        // 이진 트리 연결
        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);
        node3.addLeft(node6);
        node3.addRight(node7);

        // 출력
        System.out.print("전위 순회: ");
        tree.preOrder(node1);
        System.out.println();

        System.out.print("중위 순회: ");
        tree.inOrder(node1);
        System.out.println();

        System.out.print("후위 순회: ");
        tree.postOrder(node1);
        System.out.println();
    }
}