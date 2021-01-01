<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Vungmiens;
use Validator;
use DB;
class VungmienController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Responses
     */
    public function __construct(){
        $this->middleware('auth:nguoidung');
    }
    public function index()
    {
        $vungmien = DB::table('vungmiens')->paginate('3');
        return view('admin.vungmien.index',compact('vungmien'));
        //$arr['vungmien']=Vungmiens::all();
        //return view('admin.vungmien.index')->with($arr);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('admin.vungmien.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request,Vungmiens $vungmien)
    {
        $rule=['ten_vungmien'=>'required|min:3','noidung'=>'required|min:10'];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
        return redirect()->route('home.vungmien.create');
    }
        $vungmien->ten_vungmien=$request->ten_vungmien;
        $vungmien->noidung=$request->noidung;
        $vungmien->save();
        return redirect()->route('home.vungmien.index');
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
    public function edit(Vungmiens $vungmien)
    {
        $arr['vungmien']=$vungmien;
        return view('admin.vungmien.edit')->with($arr);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Vungmiens $vungmien)
    {
        $rule=['ten_vungmien'=>'required|min:3','noidung'=>'required|min:10'];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
        return redirect()->route('home.vungmien.create');
    }
        $vungmien->ten_vungmien=$request->ten_vungmien;
        $vungmien->noidung=$request->noidung;
        $vungmien->save();
        return redirect()->route('home.vungmien.index');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        Vungmiens::destroy($id);
        return redirect()->route('home.vungmien.index');
    }
    public function search(){
        $search_text=$_GET['query'];
        $vungmien=Vungmiens::where('ten_vungmien','LIKE','%'.$search_text.'%')->paginate('3');
        if(!$search_text)
            return redirect()->route('home.vungmien.index');
        return view('admin.vungmien.index',compact('vungmien'));
    }
}