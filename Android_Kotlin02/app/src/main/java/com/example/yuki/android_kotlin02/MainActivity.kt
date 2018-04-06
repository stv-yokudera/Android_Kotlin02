package com.example.yuki.android_kotlin02

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listType()
        operateList()
        mapType()
        setType()
    }

    private fun listType() {

        val mutableList = mutableListOf(1, 2, 3, 4, 5)
        val list: List<Int> = mutableList

        println("$mutableList size: ${mutableList.size}")
        println("$list size: ${list.size}")

        mutableList.add(6)

        // mutableListが書き変わると、listも変わる
        println("$mutableList size: ${mutableList.size}")
        println("$list size: ${list.size}")

        // MutableListは、要素を変更可能。（Listは不可。）
        // privateなMutableListを外部にListとして公開するとか可能。
        mutableList[0] = 0
        println("$mutableList size: ${mutableList.size}")
        println("$list size: ${list.size}")

        val list2 = listOf("Kotlin", "Java", null, null)
        println("$list2 size: ${list2.size}")

        // nullを除いたList
        val notNullList = listOfNotNull("Kotlin", "Java", null, null)
        println("$notNullList size: ${notNullList.size}")
    }

    /**
     * Listを操作する
     */
    private fun operateList() {

        val list = listOf(1, 2, 3, 4, 5)
        println(list)
        // originalListの各要素を10倍した新しいListを生成する
        println(list.map { num -> num * 10 })

        val twoDimensionalList = listOf(listOf(1, 2), listOf(3, 4, 5))
        println(twoDimensionalList)
        // twoDimensionalListを1次元に変換した新しいListを生成する
        println(twoDimensionalList.flatMap { num -> num })

        val list2 = listOf(0, 50, 100, 150, 200)
        println("$list size: ${list.size}")
        // list2から100以上200未満の要素を抽出して新しいListを生成する
        val extractedList = list2.filter { num -> num >= 100 && num < 200 }
        println("$extractedList size: ${extractedList.size}")

        // falseを返した要素のみ抽出する
        val notApplyList = list2.filterNot { num -> num >= 100 && num < 200 }
        println("$notApplyList size: ${notApplyList.size}")

        val list3 = listOf(1, 2, 3, 4, 5)
        // 先頭から指定した数だけ要素を抽出する
        val takeList = list3.take(2)
        println("$takeList size: ${takeList.size}")
        // 末尾から指定した数だけ要素を抽出する
        val takeLastList = list3.takeLast(2)
        println("$takeLastList size: ${takeLastList.size}")

        val list4 = listOf(0, 1, 2, 3, 4, 5)
        // 最大値を取得する
        val maxValue = list4.max()
        println("max $maxValue")
        // 最小値を取得する
        val minValue = list4.min()
        println("min $minValue")

        val list5 = listOf("Java", "Kotlin", "Android", "Java")
        println("$list5 size: ${list5.size}")
        // 重複を削除する
        val distinctList = list5.distinct()
        println("$distinctList size: ${distinctList.size}")
    }

    private fun mapType() {
        val map = mapOf(0 to "a", 1 to "b")
        println(map[0])

        val mutableMap = mutableMapOf(0 to "jp", 1 to "en")
        println(mutableMap[0])
        // MutableMapは、要素を変更可能。（Mapは不可。）
        mutableMap[0] = "JP"
        println(mutableMap[0])
    }

    private fun setType() {

        // Setは重複を持たない
        // SetはListとは異なり、順序が保証されていない
        val intSet = setOf(1, 2, 3, 4, 5, 4, 3, 2, 1, 0)
        println(intSet)

        val mutableIntSet = mutableSetOf(1, 2, 3, 4, 5, 4, 3, 2, 1, 0)
        println(mutableIntSet)

        // MutableSetは、値を変更可能。（Setは不可。）
        mutableIntSet += 10
        println(mutableIntSet)

        mutableIntSet -= 0
        println(mutableIntSet)
    }
}
