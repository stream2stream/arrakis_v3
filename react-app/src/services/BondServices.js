import http from "axios";
import moment from "moment";
//npm install moment --save

// const bonds = [
//     {
//         issuerName:'BNPParibasIssu 4,37% Microsoft Corp (USD)',
//         isin:'XS1988387210',
//         bondMaturityDate:Date.parse('05/08/2021'),
//         couponPercent:4.37,
//         faceValue:1000
//     }, {
//         issuerName:'Airbus 3.15%  USD',
//         isin:'USN0280EAR64',
//         bondMaturityDate:Date.parse('30/07/2021'),
//         couponPercent:3.15,
//         faceValue:900
//     },{
//         issuerName:'UBS Facebook (USD)',
//         isin:'A12356111',
//         bondMaturityDate:Date.parse('30/09/2021'),
//         couponPercent:2,
//         faceValue:900
//     }
//   ]

// export const getAllBonds = () => {
//   ; //axios.get(`${hostNameUrl}/dogs`);
//   return bonds;
// };

export function getAllBonds(){
    return http.get("http://localhost:8080/api/v1/bondsdata/all")
}

// export const getBondsByDate = (date) => {
//     return bonds.filter(function(itm) {
//         return itm.bondMaturityDate == date;
//     })
// }

export function getBondsByDate(props){
    //console.log('final ' + props.customFormat( "#DD#/#MM#/#YYYY#"));
    //console.log(Date.parse(props).toString("YYYY/MM/DD"));
    var date = props;
    date = moment(date).format('YYYY-MM-DD');
    console.log(date);
    return http.get("http://localhost:8080/api/v1/bondsdata/all/{date}?date="+date)
}