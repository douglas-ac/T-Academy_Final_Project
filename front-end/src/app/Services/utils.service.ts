import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {

  constructor() { }

  clearObject(obj: any){
    for(let [key, value] of Object.entries(obj)){
      if(Array.isArray(value)){
        obj[key] = []
      } else if(typeof value == 'object' && value != null){
        this.clearObject(value)
      } else{
        obj[key] = null
      }
    }
  }

  addValueToObject(obj:object, key: any, value: any){
    let k = key as keyof typeof obj
    if(Array.isArray(obj[k])){
      const myArray = (obj[k] as Array<any>)
      if(myArray.indexOf(value) == -1){
        myArray.push(value)
      } else{
        const index = myArray.indexOf(value);
        if (index > -1) {
          myArray.splice(index, 1);
        }
      }
    }
  }
}
