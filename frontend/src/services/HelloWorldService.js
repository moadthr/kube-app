import axios from 'axios';

const USER_API_BASE_URL =  "/api/v1/hello";

class HelloWorldService {

    getMessage(){
        return axios.get(USER_API_BASE_URL);
    }
}

export default new HelloWorldService()