class ItemsController < ApplicationController
	before_action :set_user
	before_action :set_user_item, only: [:show, :update, :destroy]

	def index
		json_response(@user.items)
	end

	def show
		json_response(@item)
	end

	def create
		@user.items.create!(item_params)
	    json_response(@user, :created)
	end

	def destroy
		@item.destroy
		head :no_content
	end

	def update
		@item.update(item_params)
		head :no_content
	end

	private

	def set_user
		@user = User.find(params[:user_id])
	end

	def set_user_item
		@item = @user.items.find_by!(id: params[:id]) if @user
	end

	def item_params
		params.permit(:name,:itemType,:value)
	end

end
