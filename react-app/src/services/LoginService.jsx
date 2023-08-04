import { hostNameUrl } from "../config/api";
import axios from "axios";


export const SignIn = async (emailReceived, passwordReceived ) => {
    
    try {
      console.log(emailReceived)
      console.log(passwordReceived)
      const response = await axios.post(`${hostNameUrl}/users/signin`, {
        email: emailReceived,
        password: passwordReceived
      });
      localStorage.setItem('jwtToken', response.data);
     
      return response.data;
    } catch (error) {
      console.error("Error fetching bonds:", error);
      throw error;
    }
  };