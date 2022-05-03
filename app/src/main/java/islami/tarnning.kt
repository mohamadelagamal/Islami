package islami

import java.util.*

fun main() {
    val items = intArrayOf(2,8,9,10)
    print(Arrays.toString(itemSum(items,10)))
}

//........... O(n)=n2 , S(n)=1
fun itemSum(items: IntArray, target: Int): IntArray {

    for (i in items.indices){
        for ( j in (i+1) until items.size){
            if (items[j] == target-items[i])
                return intArrayOf(i,j)
        }
    }
    throw IllegalArgumentException("no available number in array")
}
//........... O(n)=n , S(n)=2
 fun towSum2(a: IntArray, target: Int): IntArray? {
    val map: HashMap<*, *> = HashMap<Int, Int>()
    for (i in a.indices) {
        val comp = target - a[i]
        if (!map.containsKey(comp)) map.put(a[i] as Nothing, i as Nothing) else return intArrayOf(i, map[comp] as Int)
    }
    throw IllegalArgumentException("not available numbers")
}