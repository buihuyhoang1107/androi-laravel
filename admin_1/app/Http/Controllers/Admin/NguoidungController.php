<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Nguoidungs;
use Validator;
use DB;
class NguoidungController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function __construct(){
        $this->middleware('auth:nguoidung');
    }
    public function index()
    {
        $arr['nguoidung']=Nguoidungs::all();
        
        return view('admin.nguoidung.index')->with($arr);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {       
        $arr['nguoidung']=Nguoidungs::all();
        return view('admin.nguoidung.create')->with($arr);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request, Nguoidungs $nguoidung)
    {
        $rule=['ten'=>'required|min:3',
                'gmail'=>'required|email',];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
        return redirect()->route('home.nguoidung.create');
    }
        $nguoidung->ten=$request->ten;
        $nguoidung->gmail=$request->gmail;
        $nguoidung->matkhau=$request->matkhau;
        $nguoidung->phanquyen=0;
        $nguoidung->action=0;
        $nguoidung->save();
        return redirect()->route('home.nguoidung.index');
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit(Nguoidungs $nguoidung)
    {
        $arr['nguoidung']=$nguoidung;
        return view('admin.nguoidung.edit')->with($arr);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request,Nguoidungs $nguoidung)
    {
        $rule=['ten '=>'required|min:3',
                'gmail'=>'required|email'];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
        return redirect()->route('home.nguoidung.create');
    }
        $nguoidung->ten=$request->ten;
        $nguoidung->gmail=$request->gmail;
        $nguoidung->matkhau=$request->matkhau;
        $nguoidung->phanquyen=$request->phanquyen;
        $nguoidung->action=$request->action;
        $nguoidung->save();
        return redirect()->route('home.nguoidung.index');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        Nguoidungs::destroy($id);
        return redirect()->route('home.nguoidung.index');
    }
}
