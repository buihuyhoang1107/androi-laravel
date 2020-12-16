<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Category;
use App\Vungmiens;
use App\Baiviets;
use DB;
use Validator;
class BaivietController extends Controller
{
    public function __construct(){
        $this->middleware('auth');
    }
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $arr['baiviet']=Baiviets::all();
        return view('admin.baiviet.index')->with($arr);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $arr['categories']=Category::all();
        $arr['vungmiens']=Vungmiens::all();
        return view('admin.baiviet.create')->with($arr);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request,Baiviets $baiviet)
    {
        $rule=['ten'=>'required|min:3',
                'nguyenlieu'=>'required|min:10', 
                'soche'=>'required|min:10',
                'thuchien'=>'required|min:10',
                'cachdung'=>'required|min:3',   
                'hinhanh'=>'required'];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
            return redirect()->route('home.baiviet.create');
        }
        if($request->hinhanh->getClientOriginalName())
        {
            $ext= $request->hinhanh->getClientOriginalExtension();
            $file = date('YmdHis').rand(1,9999).'.'.$ext;
            $request->hinhanh->storeAs('public/baiviet',$file);
        }
        else{
            $file='';
        }
        $baiviet->hinhanh=$file;
        $baiviet->ten=$request->ten;
        $baiviet->nguyenlieu=$request->nguyenlieu;
        $baiviet->soche=$request->soche;
        $baiviet->thuchien=$request->thuchien;
        $baiviet->cachdung=$request->cachdung;
        $baiviet->category_id=$request->category_id;
        $baiviet->vungmien_id=$request->vungmien_id;
        $baiviet->save();
        return redirect()->route('home.baiviet.index');
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
    public function edit(Baiviets $baiviet )
    {
        $arr['baiviet']=$baiviet;
        $arr['categories']=Category::all();
        $arr['vungmiens']=Vungmiens::all();
        return view('admin.baiviet.edit')->with($arr);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Baiviets $baiviet)
    {
         $rule=['ten'=>'required|min:3',
                'nguyenlieu'=>'required|min:10', 
                'soche'=>'required|min:10',
                'thuchien'=>'required|min:10',
                'cachdung'=>'required|min:3',   
                'hinhanh'=>'required'];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
            return redirect()->route('home.baiviet.create');
        }
        if(isset($request->hinhanh)&&$request->hinhanh->getClientOriginalName())
        {
            $ext= $request->hinhanh->getClientOriginalExtension();
            $file = date('YmdHis').rand(1,9999).'.'.$ext;
            $request->hinhanh->storeAs('public/baiviet',$file);
        }
        else{
            if(!$baiviet->hinhanh)
                $file='';
            else
                $file=$baiviet->hinhanh;
        }
        $baiviet->hinhanh=$file;
        $baiviet->ten=$request->ten;
        $baiviet->nguyenlieu=$request->nguyenlieu;
        $baiviet->soche=$request->soche;
        $baiviet->thuchien=$request->thuchien;
        $baiviet->cachdung=$request->cachdung;
        $baiviet->category_id=$request->category_id;
        $baiviet->vungmien_id=$request->vungmien_id;
        $baiviet->save();
        return redirect()->route('home.baiviet.index');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        Baiviets::destroy($id);
        return redirect()->route('home.baiviet.index');
    }
}
