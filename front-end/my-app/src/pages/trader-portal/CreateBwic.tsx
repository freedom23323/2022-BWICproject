import { ChangeEvent, FormEvent, useState } from 'react';
import { BwicItem } from '../../Model/Bwic.model';
import './CreateBwic.scss';
const CreateBwic_Origianl=()=>{
    const initateBwic={
        cusip:"cusip1",
        issuer:"issuer1",
       // dueDate:"2022-06-27",
        owner:"yixinzhi",
        size:1000,
        price:100,
    }as BwicItem

    const [bwicObj,setBwicObj]=useState(initateBwic);



  const changeEvent = (event: ChangeEvent) => {
    const ele = event.target as HTMLInputElement;
    const value = ele.value;
    const name = ele.name;
    const newBwicObj = { ...bwicObj, ...{ [name]: value } };
    setBwicObj(newBwicObj);
  }

  const submitEvent = (event: FormEvent) => {
    // Call API, 
    alert(JSON.stringify(bwicObj));
    event.preventDefault();
  }


    return (
        <div className="container">
            <h1>Create BWIC</h1>
            <form className="form-panel" onSubmit={submitEvent}>
               <div className="form-group">
                <label>Cuisp</label>
                <input type="text" name="cusip" value={bwicObj.cusip} onChange={changeEvent}/>
               </div>
               <div className="form-group">
                <label>Issuer</label>
                <input type="text" name="issuer" value={bwicObj.issuer} onChange={changeEvent}/>
               </div>
               <div className="form-group">
                <label>Due Date</label>
                {/* <input type="text" name="dueDate" value={new Date()} onChange={changeEvent}/> */}
               </div>
               <div className="form-group">
                <label>Bond Owner</label>
                <input type="text" name="owner" value={bwicObj.owner} onChange={changeEvent}/>
               </div>
               <div className="form-group">
                <label>Size</label>
                <input type="text" name="size" value={bwicObj.size} onChange={changeEvent}/>
               </div>
               <div className="form-group">
                <label>RecommendPrice</label>
                <input type="text" name="price" value={bwicObj.price} onChange={changeEvent}/>
               </div>
               <div className='button-group'>
                  <button type="submit">Submit</button>
               </div>
            </form>
        </div>
    )
}
export default CreateBwic_Origianl;