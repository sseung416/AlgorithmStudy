package tree;

public class BinarySearchTree {

    private Node root; // 상위 노드

    public BinarySearchTree() {
        root = null;
    }

    public Node search(int value) {
        return searchNode(root, value);
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    public void remove(int value) {
        root = removeNode(root, value);
    }

    // 중위순위 (왼->루트->오)
    public void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.println(node.value);
        printTree(node.right);
    }

    private Node searchNode(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value == node.value) {
            // 값을 찾으면 해당 노드를 반환
            return node;
        } else if (value > node.value) {
            // 값이 노드의 값보다 큰 경우, 오른쪽 서브트리를 탐색
            searchNode(node.right, value);
        } else {
            // 값이 노드의 값보다 작은 경우, 왼쪽 서브트리를 탐색
            searchNode(node.left, value);
        }

        return null;
    }

    private Node insertNode(Node node, int value) {
        if (node == null) {
            // 가장 아래 부분(트리의 높이)까지 내려왔으면 새 노드 생성 후 반환
            node = new Node(value);
            return node;
        }

        if (value > node.value) {
            // 삽입하려는 값이 상위 노드의 값보다 클 때, 오른쪽 노드에 추가
            node.right = insertNode(node.right, value);
        } else if (value < node.value) {
            // 삽입하려는 값이 상위 노드의 값보다 작을 때, 왼쪽 노드에 추가
            node.left = insertNode(node.left, value);
        }

        // 상위 노드와 하위 노드의 값이 같으면 삽입하지 않음 (중복 X)
        return node;
    }

    private Node removeNode(Node node, int value) {
        if (node == null) {
            // 삭제해야 하는 노드가 없는 경우
            return null;
        }

        if (value < node.value) {
            node.left = removeNode(node.left, value);
        } else if (value > node.value) {
            node.right = removeNode(node.right, value);
        } else {
            // 삭제해야 하는 노드를 찾은 경우

            // 리프 노드이거나 자식 노드가 1개 일 때
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // 자식 노드가 2개일 때, 중위 순위를 통해 successor 값 조회함
            // successor 노드의 값과 삭제할 node의 값을 바꿔줌
            node.value = getMinValue(node.right);

            // successor 노드를 삭제함
            node.right = removeNode(node.right, node.value);
        }
        return node;
    }

    // successor 값(오른쪽 서브트리의 최솟값)을 반환하는 함수
    private int getMinValue(Node node) {
        int minValue = node.value;
        while (node.left != null) {
            // 노드의 왼쪽 자식 노드가 없을 때까지 반복
            // 자식 노드가 없다면 가장 최솟값을 찾은 것
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    public static void run() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(10);
        bst.insert(20);
        bst.insert(23);
        bst.insert(3);

        bst.remove(10);
        bst.remove(30);

        bst.printTree(bst.root);
        System.out.println("search: " + bst.search(5).value);
        System.out.println("search: " + bst.search(10));
    }
}

class Node {
    int value;

    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}