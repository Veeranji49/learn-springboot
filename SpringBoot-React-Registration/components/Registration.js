import React,{useState} from "react";
import axios from "axios";

const Registration=()=>{

    const[id,setId]=useState("");
    const[name,setName]=useState("");
    const[salary,setSalary]=useState("");
    const[address,setAddress]=useState("");
    const[company_name,setCompany_name]=useState("");

    async function save(e)
    {
        e.preventDefault(e.target.value);
        try{
            await axios.post("http://localhost:4000/api/v1/employee/save",
            {
                id:id,
                name:name,
                salary:salary,
                address:address,
                company_name:company_name
            }
            );

            alert("Employee Registration Successfully");
            setId("");
            setName("");
            setAddress("");
            setSalary("");
            setCompany_name("");
        }
        catch(err)
        {
            alert("Employee Registration failed");
        }
    }
    return(
        <div class="bg-success text-center">
            <h1 style={{color:"red"}}>Employee Registration Form</h1>
            <form class="col-md-4 offset-md-4">
    <div class="form-group">
    <label for="id">Employee Id</label>
    <input type="text" class="form-control mb-2" id="id"  placeholder="Enter id" 
    value={id} onChange={(e)=>setId(e.target.value)} />
  </div>
  <div class="form-group">
    <label for="name">Employee name</label>
    <input type="text" class="form-control mb-2" id="name"  placeholder="Enter name" 
    value={name} onChange={(e)=>setName(e.target.value)} />
  </div>
  <div class="form-group">
    <label for="salary">Employee salary</label>
    <input type="text" class="form-control mb-2" id="salary"  placeholder="Enter salary" 
    value={salary} onChange={(e)=>setSalary(e.target.value)} />
  </div>
  <div class="form-group">
    <label for="address">Employee address</label>
    <input type="text" class="form-control mb-2" id="address"  placeholder="Enter address" 
    value={address} onChange={(e)=>setAddress(e.target.value)} />
  </div>
  <div class="form-group ">
    <label for="company_name">Employee  comapany name</label>
    <input type="text" class="form-control mb-2" id="company_name"  placeholder="Enter Comapany" 
    value={company_name} onChange={(e)=>setCompany_name(e.target.value)} />
  </div>
  
  <button onClick={save} class="btn btn-primary">Submit</button>
</form>
        </div>
    );
}
export default Registration;