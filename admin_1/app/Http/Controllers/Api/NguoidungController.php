<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Nguoidungs;
class NguoidungController extends Controller
{
    public function Swap($id){
        $nguoidung =Nguoidungs::find($id);
        $nguoidung->action = !$nguoidung->action;
        $nguoidung->save();
        return response()->json($nguoidung,201);
    }
}
