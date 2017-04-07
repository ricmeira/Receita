require 'rails_helper'

RSpec.describe 'Items API', type: :request do
	  # initialize test data 
  let!(:user) { create(:user) }
  let!(:items) { create_list(:item, 20, user_id: user.id) }
  let(:user_id) { user.id }
  let(:id) { items.first.id }

    # Test suite for GET /users/:user_id/items
  	describe 'GET /users/:user_id/items' do
	    # make HTTP get request before each example
	    before { get "/users/#{user_id}/items" }

	    context 'when user exists' do
		    it 'returns items' do
		      # Note `json` is a custom helper to parse JSON responses
		      expect(json).not_to be_empty
		      expect(json.size).to eq(20)
		    end

		    it 'returns status code 200' do
		      expect(response).to have_http_status(200)
		    end
		end

		context 'when user does not exists' do
			let(:user_id) { 0 }

			it 'returns status code 404' do
				expect(response).to have_http_status(404)
			end

			it 'returns a not found message' do
	        	expect(response.body).to match(/Couldn't find User/)
	      	end
		end
	end

	# Test suite for GET /users/:user_id/items/:id
	describe 'GET /users/:user_id/items/:id' do
		before { get "/users/#{user_id}/items/#{id}" }

		context 'when user item exists' do
			it 'returns the item' do
        		expect(json).not_to be_empty
        		expect(json['id']).to eq(id)
      		end

			it 'returns status code 200' do
		    	expect(response).to have_http_status(200)
			end
		end

		context 'when the user item does not exists' do
			let(:id){0}
			it 'returns status code 404' do
				expect(response).to have_http_status(404)
			end

			it 'returns a not found message' do
	        	expect(response.body).to match(/Couldn't find Item/)
	      	end
		end
	end

	#Test suite for POST /users/:user_id/items
  	describe 'POST /users/:user_id/items' do
		let(:valid_attributes) {{name:'testItem',itemType:"testType",value:"25.23",}}

  		context 'when the request is valid' do
  			before {post "/users/#{user_id}/items",params:valid_attributes}

	      	it 'returns status code 201' do
	        	expect(response).to have_http_status(201)
	      	end
	    end

	    context 'when the request is invalid' do
	    	before {post "/users/#{user_id}/items",params:{}}
	    	it 'returns status code 422' do
	        	expect(response).to have_http_status(422)
	      	end
	    end
  	end

	#Test suite for DELETE /users/:user_id/items/:id
	describe 'DELETE /users/:id/item/:id' do
		before { delete "/users/#{user_id}/items/#{id}" }

	    it 'returns status code 204' do
	      expect(response).to have_http_status(204)
	    end
	end

	#Test suite for PUT /users/:user_id/items/:id
	describe 'PUT /users/:id/item/:id' do
		let(:valid_attributes) { { name: 'updated' } }

	    before { put "/users/#{user_id}/items/#{id}", params: valid_attributes }

	    context 'when item exists' do
	      it 'returns status code 204' do
	        expect(response).to have_http_status(204)
	      end

	      it 'updates the item' do
	        updated_item = Item.find(id)
	        expect(updated_item.name).to match(/updated/)
	      end
	    end

	    context 'when the item does not exist' do
	      let(:id) { 0 }

	      it 'returns status code 404' do
	        expect(response).to have_http_status(404)
	      end

	      it 'returns a not found message' do
	        expect(response.body).to match(/Couldn't find Item/)
	      end
	    end
	end
end