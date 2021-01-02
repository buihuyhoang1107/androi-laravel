<?php

namespace App\Http\Controllers\Admin;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Category;
use Validator;
use DB;
class CategoriesController extends Controller
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
        //$category=Baiviets::with('category')->paginate(2); 
        $categories = DB::table('categories')->paginate('4');
        return view('admin.categories.index',compact('categories'));
      
    }
    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('admin.categories.create');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request,Category $category)
    {
        $rule=['title'=>'required|min:3',];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
        return redirect()->route('home.categories.create');
    }
    if($request->hinhanh->getClientOriginalName())
        {
            $ext= $request->hinhanh->getClientOriginalExtension();
            $file = date('YmdHis').rand(1,9999).'.'.$ext;
            $request->hinhanh->storeAs('public/category',$file);
        }
        else{
            if(!$category->hinhanh)
                $file='';
            else
                $file=$category->hinhanh;
        }
        $category->hinhanh=$file;
        $category->title=$request->title;
        $category->save();
        return redirect()->route('home.categories.index');
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
    public function edit(Category $category)
    {
        $arr['category']=$category;
        return view('admin.categories.edit')->with($arr);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request,Category $category)
    {
        $rule=['title'=>'required|min:3',];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
        return redirect()->route('home.categories.edit');
        }
        if(isset($request->hinhanh)&&$request->hinhanh->getClientOriginalName())
        {
            $ext= $request->hinhanh->getClientOriginalExtension();
            $file = date('YmdHis').rand(1,9999).'.'.$ext;
            $request->hinhanh->storeAs('public/category',$file);
        }
        else{
            if(!$category->hinhanh)
                $file='';
            else
                $file=$category->hinhanh;
        }
        $category->hinhanh=$file;
        $category->title=$request->title;
        $category->save();
        return redirect()->route('home.categories.index');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        Category::destroy($id);
        return redirect()->route('home.categories.index');
    }

    public function search(){
        $search_text=$_GET['query'];
        $categories=Category::where('title','LIKE','%'.$search_text.'%')->paginate('4');
        if(!$search_text)
            return redirect()->route('home.categories.index');
        return view('admin.categories.index',compact('categories'));
    }
}