require 'rails_helper'

RSpec.describe Item, type: :model do
  # Association test
  # ensure an item record belongs to a single user record
  it { should belong_to(:user) }
  
  # Validation test
  # ensure columns are present before saving
  it { should validate_presence_of(:name) }
  it { should validate_presence_of(:itemType) }
  it { should validate_presence_of(:value) }
end
