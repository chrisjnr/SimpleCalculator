package com.iconicdev.simplecalculator


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CalculatorInterface {
    override fun subtract(number1: Float
                          , number2: Float
    ): String {
        return (number1 - number2).toString()
    }

    override fun divide(number1: Float
                        , number2: Float
    ): String {
        return (number1 / number2).toString()
    }

    override fun multiply(number1: Float
                          , number2: Float
    ): String {
        return (number1 * number2).toString()
    }

    var calculatorResult:Float
            = 0f
    private lateinit var mainActivityViewModel:MainActivityViewModel
    private var addClicked = 1
    private var subtractClicked = 2
    private var multiplyClicked = 4
    private var divisionClicked = 3
    private var operandClicked = 0
    private var operation = false
    private var calculate: Boolean = false
    override fun add(number1: Float
                     , number2: Float
    ): String {
        return (number1 + number2).toString()
    }


    private var isdecimalSet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel =  ViewModelProviders.of(this@MainActivity).get(MainActivityViewModel::class.java)
        mainActivityViewModel.currentAnswer?.observe(this@MainActivity, Observer {
            if (it?.length ==0)
                results.text = it.trimEnd('.', '0')
            else
                results.text = it?.removeSuffix(".0")
            if ("." in it!!){
                    isdecimalSet = true
                }
        })
        calculatorResult = 0f

        deleteButtton.setOnClickListener{
            mainActivityViewModel.setCurrentAnswer("0")
            calculatorResult = 0f
        }

        buttton_7.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0"))
                    mainActivityViewModel.setCurrentAnswer("7")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "7")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "7")

                }

            }

        }

        buttton_8.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0"))
                    mainActivityViewModel.setCurrentAnswer("8")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "8")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "8")

                }

            }
        }

        buttton_9.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0"))
                    mainActivityViewModel.setCurrentAnswer("9")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "9")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "9")
                }

            }
        }
        buttton_4.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString() == "0")
                    mainActivityViewModel.setCurrentAnswer("4")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "4")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "4")

                }

            }
        }
        buttton_5.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0"))
                    mainActivityViewModel.setCurrentAnswer("5")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "5")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "5")

                }

            }
        }
        buttton_6.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0"))
                    mainActivityViewModel.setCurrentAnswer("6")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "6")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "6")

                }

            }
        }
        buttton_1.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0"))
                    mainActivityViewModel.setCurrentAnswer("1")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "1")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "1")
                }

            }
        }
        buttton_2.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0"))
                    mainActivityViewModel.setCurrentAnswer("2")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "2")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "2")

                }

            }
        }
        buttton_3.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0"))
                    mainActivityViewModel.setCurrentAnswer("3")
                else
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "3")
            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "3")
                }

            }
        }

        buttton_0.setOnClickListener{
            if (!operation && !calculate){
                if (results.text.toString().equals("0")){
                    mainActivityViewModel.setCurrentAnswer("0")
                }

                else{
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "0")
                }

            }else{
                if (operation){
                    mainActivityViewModel.setCurrentAnswer(results.text.toString() + "0")

                }

            }

        }


        addition_button.setOnClickListener{
            if (!results.text.toString().isNullOrEmpty())
                calculatorResult = results.text.toString().toFloat()
            operation = true
            operandClicked = 1
            results.text = ""
            isdecimalSet = false
        }

        subtract_button.setOnClickListener{
            if (!results.text.toString().isNullOrEmpty())
                calculatorResult = results.text.toString().toFloat()
            operandClicked = 2
            results.text = ""
            isdecimalSet = false
        }
        division_button.setOnClickListener{
            if (!results.text.toString().isNullOrEmpty())
                calculatorResult = results.text.toString().toFloat()
            operation = true
            operandClicked = 3
            results.text = ""
            isdecimalSet = false
        }
        multiplication_button.setOnClickListener{
            if (!results.text.toString().isNullOrEmpty())
                    calculatorResult = results.text.toString().toFloat()
            operation = true
            operandClicked = 4
            results.text = ""
            isdecimalSet = false
        }

        decimal_buttton.setOnClickListener{
            if (!isdecimalSet && !results.text.isEmpty()){
                mainActivityViewModel.setCurrentAnswer(results.text.toString() + ".")
                isdecimalSet = true
            }

        }

        equalsButton.setOnClickListener{
            calculate = true
            isdecimalSet = false
//            if (calculate){
                when(operandClicked){
                    addClicked -> {
                        mainActivityViewModel.setCurrentAnswer(add(calculatorResult ,mainActivityViewModel.currentAnswer!!.value!!.toFloat()))
                        operation = false
                        calculate = false
                    }
                    subtractClicked ->{
                        mainActivityViewModel.setCurrentAnswer(subtract(calculatorResult ,mainActivityViewModel.currentAnswer!!.value!!.toFloat()))
                        operation = false
                        calculate = false
                    }
                    divisionClicked ->{
                        mainActivityViewModel.setCurrentAnswer(divide(calculatorResult , mainActivityViewModel.currentAnswer!!.value!!.toFloat()))
                        operation = false
                        calculate = false
                    }
                    multiplyClicked ->{
                        mainActivityViewModel.setCurrentAnswer(multiply(calculatorResult , mainActivityViewModel.currentAnswer!!.value!!.toFloat()))
                        operation = false
                        calculate = false
                    }
                    0->{
                        operation = false
                        calculate = false
                    }

                }
            operandClicked = 0
            operation = false
        }


    }


}
