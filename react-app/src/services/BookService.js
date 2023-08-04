import { hostNameUrl } from "../config/api";
import axios from "axios";

export const getBooks = () => {
  const pets = [{id:1,name:"Obi",age:23}];
  //const pets = axios.get(`${hostNameUrl}/dogs`);
  return pets;
}

export const getTransactionsByBookId = (Id) => {
    const pets = [{id:1,name:"Obi",age:23}];
    //const pets = axios.get(`${hostNameUrl}/dogs/Id`);
    return pets;
  }

  export const getbooksByDate = (date) => {
    const pets = [{id:1,name:"Obi",age:23}];
    //const pets = axios.get(`${hostNameUrl}/dogs/Id`);
    return pets;
  }

