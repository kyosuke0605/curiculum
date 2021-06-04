let numbers = [2, 5, 12, 13, 15, 18, 22];
//ここに答えを実装してください。↓↓↓
function isEven() {
    for (let i = 0; i < numbers.length; i++) {
      if (numbers[i] % 2 === 0) {
        num = numbers[i];
        console.log(num + "は偶数です");
    }
}
}
isEven();


//問２//

//Carクラスの作成
class Car {
    //コンストラクタ
constructor(gass, num) {
  this.gass = gass;
  this.num = num;
}

getNumGas() {
  console.log(`ガソリンは${this.gass}です`);
  console.log(`ナンバーは${this.num}です`);
}
}
//carオブジェクト作成　引数がコンストラクタに代入されgetNumGasメソッドで表示される
let car = new Car(20.5, 1234);
car.getNumGas();