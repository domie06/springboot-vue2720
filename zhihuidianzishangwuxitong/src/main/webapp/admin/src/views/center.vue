<template>
	<div>
		<el-dialog title="提现" :visible.sync="dialogFormVisible">
		  <el-form>
			  <el-form-item label="提现金额">
			    <el-input v-model="jine" type="number" autocomplete="off"></el-input>
			  </el-form-item>
		    <el-form-item label="银行卡号">
		      <el-input v-model="kahao" type="number" autocomplete="off"></el-input>
		    </el-form-item>
		  </el-form>
		  <div slot="footer" class="dialog-footer">
		    <el-button @click="dialogFormVisible = false">取 消</el-button>
		    <el-button type="primary" @click="quedingtixian">确 定</el-button>
		  </div>
		</el-dialog>
		
		<el-form class="detail-form-content" ref="ruleForm" :model="ruleForm" label-width="80px">
			<el-row>
				<el-col :span="12">
					<el-form-item v-if="flag=='shangjia'" label='商家名称' prop="shangjiaName">
						<el-input v-model="ruleForm.shangjiaName" placeholder='商家名称' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='shangjia'" label='联系方式' prop="shangjiaPhone">
						<el-input v-model="ruleForm.shangjiaPhone" placeholder='联系方式' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='shangjia'" label='邮箱' prop="shangjiaEmail">
						<el-input v-model="ruleForm.shangjiaEmail" placeholder='邮箱' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='shangjia'" label='营业执照展示' prop="shangjiaPhoto">
						<file-upload tip="点击上传照片" action="file/upload" :limit="3" :multiple="true"
							:fileUrls="ruleForm.shangjiaPhoto?ruleForm.shangjiaPhoto:''"
							@change="shangjiaPhotoUploadChange"></file-upload>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item v-if="flag=='shangjia'" label='商家星级类型' prop="shangjiaXingjiTypes">
						<el-select v-model="ruleForm.shangjiaXingjiTypes" disabled placeholder='请选择商家星级类型'>
							<el-option v-for="(item,index) in shangjiaXingjiTypesOptions" v-bind:key="item.codeIndex"
								:label="item.indexName" :value="item.codeIndex">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item v-if="flag=='shangjia'" label='现有余额' prop="newMoney">
						<el-input v-model="ruleForm.newMoney" placeholder='现有余额' disabled></el-input>					
						<el-button type="text" @click="dialogFormVisible = true">提现</el-button>
					</el-form-item>
				</el-col>
				<el-col :span="24">
					<el-form-item v-if="flag=='shangjia'" label="商家简介" prop="shangjiaContent">
						<editor style="min-width: 200px; max-width: 600px;" v-model="ruleForm.shangjiaContent"
							class="editor" action="file/upload">
						</editor>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item v-if="flag=='yonghu'" label='用户姓名' prop="yonghuName">
						<el-input v-model="ruleForm.yonghuName" placeholder='用户姓名' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='yonghu'" label='头像' prop="yonghuPhoto">
						<file-upload tip="点击上传照片" action="file/upload" :limit="3" :multiple="true"
							:fileUrls="ruleForm.yonghuPhoto?ruleForm.yonghuPhoto:''" @change="yonghuPhotoUploadChange">
						</file-upload>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item v-if="flag=='yonghu'" label='联系方式' prop="yonghuPhone">
						<el-input v-model="ruleForm.yonghuPhone" placeholder='联系方式' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='yonghu'" label='用户身份证号' prop="yonghuIdNumber">
						<el-input v-model="ruleForm.yonghuIdNumber" placeholder='用户身份证号' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='yonghu'" label='邮箱' prop="yonghuEmail">
						<el-input v-model="ruleForm.yonghuEmail" placeholder='邮箱' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='yonghu'" label='余额' prop="newMoney">
						<el-input v-model="ruleForm.newMoney" placeholder='余额' disabled></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item v-if="flag=='zhiyuanzhe'" label='志愿者姓名' prop="zhiyuanzheName">
						<el-input v-model="ruleForm.zhiyuanzheName" placeholder='志愿者姓名' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='zhiyuanzhe'" label='头像' prop="zhiyuanzhePhoto">
						<file-upload tip="点击上传照片" action="file/upload" :limit="3" :multiple="true"
							:fileUrls="ruleForm.zhiyuanzhePhoto?ruleForm.zhiyuanzhePhoto:''"
							@change="zhiyuanzhePhotoUploadChange"></file-upload>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item v-if="flag=='zhiyuanzhe'" label='联系方式' prop="zhiyuanzhePhone">
						<el-input v-model="ruleForm.zhiyuanzhePhone" placeholder='联系方式' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item v-if="flag=='zhiyuanzhe'" label='邮箱' prop="zhiyuanzheEmail">
						<el-input v-model="ruleForm.zhiyuanzheEmail" placeholder='邮箱' clearable></el-input>
					</el-form-item>
				</el-col>

				<el-form-item v-if="flag=='users'" label="用户名" prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-col :span="12">
					<el-form-item v-if="flag!='users'" label="性别" prop="sexTypes">
						<el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
							<el-option v-for="(item,index) in sexTypesOptions" v-bind:key="item.codeIndex"
								:label="item.indexName" :value="item.codeIndex">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="24">
					<el-form-item>
						<el-button type="primary" @click="onUpdateHandler">修 改</el-button>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
	</div>
</template>
<script>
	// 数字，邮件，手机，url，身份证校验
	import {
		isNumber,
		isIntNumer,
		isEmail,
		isMobile,
		isPhone,
		isURL,
		checkIdCard
	} from "@/utils/validate";

	export default {
		data() {
			return {
				dialogFormVisible:false,
				jine:null,
				kahao:null,
				ruleForm: {},
				flag: '',
				usersFlag: false,
				sexTypesOptions: [],
				shangjiaXingjiTypesOptions: [],
			};
		},
		mounted() {
			//获取当前登录用户的信息
			var table = this.$storage.get("sessionTable");
			this.sessionTable = this.$storage.get("sessionTable");
			this.role = this.$storage.get("role");
			if (this.role != "管理员") {}

			this.flag = table;
			this.$http({
				url: `${this.$storage.get("sessionTable")}/session`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.ruleForm = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.$http({
				url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.sexTypesOptions = data.data.list;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.$http({
				url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=shangjia_xingji_types`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					this.shangjiaXingjiTypesOptions = data.data.list;
				} else {
					this.$message.error(data.msg);
				}
			});
		},
		methods: {
			quedingtixian(){
				if(this.jine == null || this.jine == ""){
					this.$message.error('提现金额不能为空');
					return
				}
				if(this.kahao == null || this.kahao ==""){
					this.$message.error('银行卡号不能为空');
					return
				}
				if(this.ruleForm.newMoney< this.jine){
					this.$message.error('余额不足');
					return
				}
				this.ruleForm.newMoney = Number(this.ruleForm.newMoney - this.jine)
				this.$http({
					url: `shangjia/update`,
					method: "post",
					data: this.ruleForm
				}).then(({
					data
				}) => {
					if (data && data.code === 0) {
						this.$message({
							message: "提现成功",
							type: "success",
							duration: 1500,
							onClose: () => {
								this.dialogFormVisible = false								
							}
						});
					} else {
						this.$message.error(data.msg);
						this.dialogFormVisible = false
					}
				});
				
				
			},
			shangjiaPhotoUploadChange(fileUrls) {
				this.ruleForm.shangjiaPhoto = fileUrls;
			},
			yonghuPhotoUploadChange(fileUrls) {
				this.ruleForm.yonghuPhoto = fileUrls;
			},
			zhiyuanzhePhotoUploadChange(fileUrls) {
				this.ruleForm.zhiyuanzhePhoto = fileUrls;
			},

			onUpdateHandler() {
				if ((!this.ruleForm.shangjiaName) && 'shangjia' == this.flag) {
					this.$message.error('商家名称不能为空');
					return
				}

				if ((!this.ruleForm.shangjiaPhone) && 'shangjia' == this.flag) {
					this.$message.error('联系方式不能为空');
					return
				}

				if ('shangjia' == this.flag && this.ruleForm.shangjiaEmail && (!isEmail(this.ruleForm.shangjiaEmail))) {
					this.$message.error(`邮箱应输入邮箱格式`);
					return
				}
				if ((!this.ruleForm.shangjiaPhoto) && 'shangjia' == this.flag) {
					this.$message.error('营业执照展示不能为空');
					return
				}

				if ((!this.ruleForm.shangjiaXingjiTypes) && 'shangjia' == this.flag) {
					this.$message.error('商家星级类型不能为空');
					return
				}

				if ((!this.ruleForm.shangjiaContent) && 'shangjia' == this.flag) {
					this.$message.error('商家简介不能为空');
					return
				}

				if ((!this.ruleForm.yonghuName) && 'yonghu' == this.flag) {
					this.$message.error('用户姓名不能为空');
					return
				}

				if ((!this.ruleForm.yonghuPhoto) && 'yonghu' == this.flag) {
					this.$message.error('头像不能为空');
					return
				}

				if ((!this.ruleForm.yonghuPhone) && 'yonghu' == this.flag) {
					this.$message.error('联系方式不能为空');
					return
				}

				if ((!this.ruleForm.yonghuIdNumber) && 'yonghu' == this.flag) {
					this.$message.error('用户身份证号不能为空');
					return
				}

				if ('yonghu' == this.flag && this.ruleForm.yonghuEmail && (!isEmail(this.ruleForm.yonghuEmail))) {
					this.$message.error(`邮箱应输入邮箱格式`);
					return
				}
				if ((!this.ruleForm.zhiyuanzheName) && 'zhiyuanzhe' == this.flag) {
					this.$message.error('志愿者姓名不能为空');
					return
				}

				if ((!this.ruleForm.zhiyuanzhePhoto) && 'zhiyuanzhe' == this.flag) {
					this.$message.error('头像不能为空');
					return
				}

				if ((!this.ruleForm.zhiyuanzhePhone) && 'zhiyuanzhe' == this.flag) {
					this.$message.error('联系方式不能为空');
					return
				}

				if ('zhiyuanzhe' == this.flag && this.ruleForm.zhiyuanzheEmail && (!isEmail(this.ruleForm
					.zhiyuanzheEmail))) {
					this.$message.error(`邮箱应输入邮箱格式`);
					return
				}
				if ((!this.ruleForm.sexTypes) && this.flag != 'users') {
					this.$message.error('性别不能为空');
					return
				}
				if ('users' == this.flag && this.ruleForm.username.trim().length < 1) {
					this.$message.error(`用户名不能为空`);
					return
				}
				this.$http({
					url: `${this.$storage.get("sessionTable")}/update`,
					method: "post",
					data: this.ruleForm
				}).then(({
					data
				}) => {
					if (data && data.code === 0) {
						this.$message({
							message: "修改信息成功",
							type: "success",
							duration: 1500,
							onClose: () => {}
						});
					} else {
						this.$message.error(data.msg);
					}
				});
			}
		}
	};
</script>
<style lang="scss" scoped>
</style>
