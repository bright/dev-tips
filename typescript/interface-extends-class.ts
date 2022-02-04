class MyClass {
  propA: string
  propB: string
  constructor(a: string, b: string){
    this.propA = a
    this.propB = b
  }
}
interface MyInterface extends MyClass {
  propC: string
}
const myVariable: MyInterface = {propA: ‘a’, propB: ‘b’, propC: ‘c’}
