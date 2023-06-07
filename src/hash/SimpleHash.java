package hash;

public class SimpleHash {

    public Slot[] hashTable; // 해시 저장공간 할돌

    public class Slot {
        String value;

        public Slot(String value) {
            this.value = value;
        }
    }

    public SimpleHash(int count) {
        hashTable = new Slot[count];
    }

    public int hashFunction(String key) {
        // key 값의 첫 번째 값을 조회해 해시 테이블의 길이를 나눈 나머지 값을 해시 코드로 저장
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = hashFunction(key);
        if (hashTable[address] != null) {
            // 이미 슬롯이 생성되어 있다면 그 슬롯에 value 값 적용
            hashTable[address].value = value;
        } else {
            // 슬롯이 없다면 생성 후 value 값 적
            hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        int address = hashFunction(key);
        if (hashTable[address] != null) {
            return hashTable[address].value;
        } else {
            return null;
        }
    }

    public static void run() {
        SimpleHash hash = new SimpleHash(20);
        hash.saveData("1", "111");
        hash.saveData("2", "222");
        hash.saveData("3", "333");

        System.out.println(hash.getData("2"));
        System.out.println(hash.getData("4"));
    }

    public static void runWithCrash() {
        SimpleHash hash = new SimpleHash(20);
        hash.saveData("1", "111");
        hash.saveData("2", "222");
        hash.saveData("123", "333");

        System.out.println(hash.getData("1")); // 333
        System.out.println(hash.getData("123")); // 333

        // 현재 사용하는 해시 알고리즘은 젤 앞 글자로 비교하기 때문에, 앞 글자가 동일하면 덮어 씌워진다!
    }
}
