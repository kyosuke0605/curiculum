class Taiyaki{
    constructor(nakami){
        this.nakami=nakami;
    }
    createTaiyaki(){
        console.log(`中身は${this.nakami}です。`);
    }
}
let anko = new Taiyaki("あんこ");
anko.createTaiyaki();

let cream = new Taiyaki("クリーム");
cream.createTaiyaki();

let cheese = new Taiyaki("チーズ");
cheese.createTaiyaki();