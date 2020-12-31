<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Auth;
use nguoidungs;
class LoginController extends Controller
{
    public function getAuthLogin(){
        return view('admin.login.index');
    }
    public function username(){
        return gmail;
    }
    public function logout(){
        Auth::guard('nguoidung')->logout();
        return redirect()->route('welcome');
    }
    public function postAuthLogin(Request $request){
        $arr=['gmail'=>$request->gmail,
            'password'=>$request->password];
     
        if(Auth::guard('nguoidung')->attempt($arr)&&Auth::guard('nguoidung')->user()->phanquyen==1&&Auth::guard('nguoidung')->user()->action==0){
            
            return redirect()->route('home');
        }else
        {
            return redirect()->route('welcome');
        }
    }
}
